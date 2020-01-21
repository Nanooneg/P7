package com.nanoo.library.loan.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.nanoo.library.commonsecurity.security.CommonSecurityConfig;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

/**
 * @author nanoo
 * @create 17/01/2019 - 13:30
 */
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain)
            throws ServletException, IOException {
        
        // 1. Check for token in cookie
        //Cookie cookie = WebUtils.getCookie(request, JwtConfig.HEADER);
        String token = request.getHeader(CommonSecurityConfig.HEADER);
        
        // 2. If there is no token provided and hence the user won't be authenticated.
        // It's Ok. Maybe the user accessing a public path or asking for a token.
        /*if(cookie == null) {
            chain.doFilter(request, response);
            return;
        }else {
            token = cookie.getValue();
        }*/
        
        try {	// exceptions might be thrown in creating the claims if for example the token is expired
            
            // 4. Validate the token
            DecodedJWT jwt = JWT.require(HMAC512(CommonSecurityConfig.SECRET.getBytes()))
                    .build()
                    .verify(token);
            
            String username = jwt.getSubject();
            if(username != null) {
                
                //Try to get list<GrantedAuthority from claim object in token
                String claimToString = jwt.getClaim("role").asString();
                List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
                
                if (claimToString.length() > 0)
                    grantedAuthorities.add(new SimpleGrantedAuthority(claimToString));
                
                // 5. Create auth object
                // UsernamePasswordAuthenticationToken: A built-in object, used by spring to represent the current authenticated / being authenticated user.
                // It needs a list of authorities, which has type of GrantedAuthority interface, where SimpleGrantedAuthority is an implementation of that interface
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, grantedAuthorities);
                
                // 6. Authenticate the user
                // Now, user is authenticated
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
            
        } catch (Exception e) {
            // In case of failure. Make sure it's clear; so guarantee user won't be authenticated
            SecurityContextHolder.clearContext();
        }
        
        // go to the next filter in the filter chain
        chain.doFilter(request, response);
    }
    
}