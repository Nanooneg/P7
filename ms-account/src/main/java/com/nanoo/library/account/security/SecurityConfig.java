package com.nanoo.library.account.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:24
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private AuthEntryPointJwt unauthorizedHandler;
    
    @Autowired
    public SecurityConfig(AuthEntryPointJwt unauthorizedHandler) {
        this.unauthorizedHandler = unauthorizedHandler;
    }
    
    // Roles
    private static final String ADMIN = "ADMIN";
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String CLIENT = "CLIENT";
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
        http
                // authorization requests config
                .authorizeRequests()
                .antMatchers("/consult/**").hasAnyRole(ADMIN,EMPLOYEE,CLIENT)
                .antMatchers("/create/**").hasAnyRole(ADMIN,EMPLOYEE)
                .antMatchers("/update/**").hasAnyRole(ADMIN,EMPLOYEE,CLIENT)
                .antMatchers("/delete/**").hasAnyRole(ADMIN,EMPLOYEE)
                // any other requests must be authenticated
                .anyRequest().authenticated()
                .and().httpBasic();
        
        http
                // Add a filter to check validity of token if present in request header (in a cookie)
                .addFilterBefore(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    
    }
    
}
