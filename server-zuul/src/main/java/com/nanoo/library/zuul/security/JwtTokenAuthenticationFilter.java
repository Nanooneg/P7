package com.nanoo.library.zuul.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:11
 */
public class JwtTokenAuthenticationFilter extends OncePerRequestFilter {
    
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        
        // 1. get the authentication header. Tokens are supposed to be passed in the authentication header
        String header = request.getHeader(JwtConfig.HEADER);
        
        // 2. validate the header and check the prefix
        if(header == null || !header.startsWith(JwtConfig.PREFIX)) {
            chain.doFilter(request, response);  		// If not valid, go to the next filter.
            return;
        }
        
        // If there is no token provided and hence the user won't be authenticated.
        // It's Ok. Maybe the user accessing a public path or asking for a token.
        
        // All secured paths that needs a token are already defined and secured in config class.
        // And If user tried to access without access token, then he won't be authenticated and an exception will be thrown.
        
        // 3. Get the token
        String token = header.replace(JwtConfig.PREFIX, "");
        
        try {	// exceptions might be thrown in creating the claims if for example the token is expired
            
            // 4. Validate the token
            DecodedJWT jwt = JWT.require(HMAC512(JwtConfig.SECRET.getBytes()))
                    .build()
                    .verify(token);
            
            String username = jwt.getSubject();
            if(username != null) {
                @SuppressWarnings("unchecked")
                List<String> authorities = (List<String>) jwt.getClaim("authorities");
                
                // 5. Create auth object
                // UsernamePasswordAuthenticationToken: A built-in object, used by spring to represent the current authenticated / being authenticated user.
                // It needs a list of authorities, which has type of GrantedAuthority interface, where SimpleGrantedAuthority is an implementation of that interface
                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(
                        username, null, authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
                
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
