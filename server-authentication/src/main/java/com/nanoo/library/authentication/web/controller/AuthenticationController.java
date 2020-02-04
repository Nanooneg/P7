package com.nanoo.library.authentication.web.controller;

import com.auth0.jwt.JWT;
import com.nanoo.library.authentication.model.LoginViewModel;
import com.nanoo.library.authentication.security.UserPrincipal;
import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Calendar;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

/**
 * @author nanoo
 * @create 17/01/2020 - 12:35
 */
@RestController
public class AuthenticationController {
    
    private AuthenticationManager authenticationManager;
    
    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    @PostMapping("/login")
    public String doLogin (@RequestBody LoginViewModel viewModel){
        
        return generateToken(viewModel);
        
    }
    
    @PostMapping("/manager/login")
    public String doConsistencyManagerLogin (@RequestBody LoginViewModel viewModel){
    
        return generateToken(viewModel);
    
    }
    
    @PostMapping("/refresh")
    public String doRefreshToken (@RequestBody LoginViewModel viewModel){
        
        String authenticationToken;
        String role = SecurityContextHolder.getContext().getAuthentication().getAuthorities().toString();
    

        authenticationToken = JWT
                .create()
                .withClaim("role","ROLE_" + role)
                .withSubject(viewModel.getUsername())
                .withExpiresAt(generateExpirationDate())
                .sign(HMAC512(CommonSecurityConfig.SECRET.getBytes()));

        return authenticationToken;
        
    }
    
    /**
     * This method generate a token after authenticate user
     *
     * @param viewModel user
     * @return token as a string
     */
    private String generateToken(LoginViewModel viewModel){
    
        String authenticationToken;
    
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(viewModel.getUsername(), viewModel.getPassword()));
        
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
        
            System.out.println(generateExpirationDate());
            authenticationToken = JWT
                    .create()
                    .withClaim("role","ROLE_" + principal.getRole())
                    .withSubject(principal.getUsername())
                    .withExpiresAt(generateExpirationDate())
                    .sign(HMAC512(CommonSecurityConfig.SECRET.getBytes()));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
        return authenticationToken;
    }
    
    /**
     * This method generate an expiration date with the current date
     *
     * @return a date
     */
    private Date generateExpirationDate(){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK, CommonSecurityConfig.EXPIRATION);
        return c.getTime();
    }

}
