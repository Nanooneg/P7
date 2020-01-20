package com.nanoo.library.zuul.controller;

import com.auth0.jwt.JWT;
import com.nanoo.library.zuul.model.LoginViewModel;
import com.nanoo.library.zuul.security.JwtConfig;
import com.nanoo.library.zuul.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
 * @create 13/01/2020 - 15:55
 */
@RestController
public class LoginController {
    
    private final AuthenticationManager authenticationManager;
    
    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    
    // TODO LoginViewModel validation
    @PostMapping("/login")
    public String doLogin (@RequestBody LoginViewModel viewModel){
    
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(viewModel.getUsername(), viewModel.getPassword()));
    
        SecurityContextHolder.getContext().setAuthentication(authentication);
        UserPrincipal principal = (UserPrincipal) authentication.getPrincipal();
    
        return JWT
                .create()
                .withClaim("role","ROLE_" + principal.getRole())
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtConfig.EXPIRATION))
                .sign(HMAC512(JwtConfig.SECRET.getBytes()));
        
    }
    
}
