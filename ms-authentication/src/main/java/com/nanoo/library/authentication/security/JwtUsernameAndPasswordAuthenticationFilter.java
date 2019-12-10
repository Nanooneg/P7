package com.nanoo.library.authentication.security;

import com.auth0.jwt.JWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nanoo.library.authentication.model.LoginViewModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:29
 */
public class JwtUsernameAndPasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    
    private Logger log = LoggerFactory.getLogger(this.getClass());
    
    // We use auth manager to validate the user credentials
    private AuthenticationManager authManager;
    
    
    JwtUsernameAndPasswordAuthenticationFilter(AuthenticationManager authManager) {
        this.authManager = authManager;
        
        // By default, UsernamePasswordAuthenticationFilter listens to "/login" path.
        // In our case, we use "/auth". So, we need to override the defaults.
        this.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher(JwtConfig.URI, "POST"));
    }
    
    /* Trigger when we issue POST request to /login
    We also need to pass in {"username":"dan", "password":"dan123"} in the request body */
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
            throws AuthenticationException {
    
        // Grab credentials and map them to login viewmodel
        LoginViewModel credentials = null;
        try {
            credentials = new ObjectMapper().readValue(request.getInputStream(), LoginViewModel.class);
        } catch (IOException e) {
            log.error(e.getMessage());
        }
    
        // Create login token
        assert credentials != null;
        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                credentials.getUsername(),
                credentials.getPassword(),
                new ArrayList<>());
    
        // Return authenticate user
            return authManager.authenticate(authenticationToken);
    }
    
    // Upon successful authentication, generate a token.
    // The 'auth' passed to successfulAuthentication() is the current authenticated user.
    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
    
        // Grab principal
        UserPrincipal principal = (UserPrincipal) auth.getPrincipal();
        
        
        String token = JWT.create()
                //.withHeader(headerClaims)
                .withClaim("role","ROLE_" + principal.getRole())
                .withSubject(principal.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + JwtConfig.EXPIRATION))
                .sign(HMAC512(JwtConfig.SECRET.getBytes()));
    
        // ADD COOKIES ##################################################
        Cookie cookie = new Cookie("JWTtoken", token);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        // 12 days about 999999
        cookie.setMaxAge(999999);
        cookie.setDomain("localhost");
        cookie.setPath("/");
    
        // Add token in response
        //response.addHeader(JwtConfig.HEADER, JwtConfig.PREFIX + token);
        response.addCookie(cookie);
        
        // REDIRECT ##################################################
        //response.sendRedirect("/livre/catalogue");
    }
    
}
