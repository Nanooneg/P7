package com.nanoo.library.authentication.web.controller;

import com.auth0.jwt.JWT;
import com.nanoo.library.authentication.model.LoginViewModel;
import com.nanoo.library.authentication.security.UserPrincipal;
import com.nanoo.library.commonpackage.security.CommonSecurityConfig;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

/**
 * @author nanoo
 * @create 17/01/2020 - 12:35
 */
@RestController
public class AuthenticationController {
    
    private final AuthenticationManager authenticationManager;
    
    public AuthenticationController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    // TODO LoginViewModel validation
    @PostMapping("/login")
    public String doLogin (@RequestBody LoginViewModel viewModel){
        
        String authenticationToken;
        
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(viewModel.getUsername(), viewModel.getPassword()));
    
            SecurityContextHolder.getContext().setAuthentication(authentication);
            UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
    
            authenticationToken = JWT
                    .create()
                    .withClaim("role","ROLE_" + principal.getRole())
                    .withSubject(principal.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + CommonSecurityConfig.EXPIRATION))
                    .sign(HMAC512(CommonSecurityConfig.SECRET.getBytes()));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
        
        return authenticationToken;
        
    }

}
