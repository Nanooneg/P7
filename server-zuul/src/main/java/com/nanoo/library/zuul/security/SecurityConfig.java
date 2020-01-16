package com.nanoo.library.zuul.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:24
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
    private final UserPrincipalDetailsService userPrincipalDetailsService;
    private AuthEntryPointJwt unauthorizedHandler;
    
    @Autowired
    public SecurityConfig(UserPrincipalDetailsService userPrincipalDetailsService, AuthEntryPointJwt unauthorizedHandler) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
        this.unauthorizedHandler = unauthorizedHandler;
    }
    
    // Roles
    private static final String ADMIN = "ADMIN";
    private static final String EMPLOYEE = "EMPLOYEE";
    private static final String CLIENT = "CLIENT";

    
    @Override
    protected void configure(AuthenticationManagerBuilder auth){
        auth
                .authenticationProvider(authenticationProvider());
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                // handle unauthorized access attempt to resources
                .exceptionHandling()
                .authenticationEntryPoint(unauthorizedHandler)
                .accessDeniedPage("/login")
                .and()
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
    
        http
                // authorization requests config
                .authorizeRequests()
                // authorize login process for everyone
                .antMatchers("/login").permitAll()
                // allow all who are accessing "book" service
                .antMatchers("/book/consult/**").hasAnyRole(ADMIN,EMPLOYEE)
                //.antMatchers("/book/consult/**").permitAll()
                .antMatchers("/book/create/**").hasAnyRole(ADMIN,EMPLOYEE)
                .antMatchers("/book/update/**").hasAnyRole(ADMIN,EMPLOYEE)
                .antMatchers("/book/delete/**").hasAnyRole(ADMIN,EMPLOYEE)
                // allow all who are accessing "account" service
                .antMatchers("/account/consult/**").hasAnyRole(ADMIN,EMPLOYEE,CLIENT)
                .antMatchers("/account/create/**").hasAnyRole(ADMIN,EMPLOYEE)
                .antMatchers("/account/update/**").hasAnyRole(ADMIN,EMPLOYEE,CLIENT)
                .antMatchers("/account/delete/**").hasAnyRole(ADMIN,EMPLOYEE)
                // allow all who are accessing "loan" service
                .antMatchers("/loan/consult/**").hasAnyRole(ADMIN,EMPLOYEE,CLIENT)
                .antMatchers("/loan/create/**").hasAnyRole(ADMIN,EMPLOYEE)
                .antMatchers("/loan/update/**").hasAnyRole(ADMIN,EMPLOYEE,CLIENT)
                .antMatchers("/loan/delete/**").hasAnyRole(ADMIN,EMPLOYEE)
                // any other requests must be authenticated
                .anyRequest().authenticated()
                .and().httpBasic();
        http
                // Add a filter to check validity of token if present in request header (in a cookie)
                .addFilterBefore(new JwtTokenAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
    
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    @Bean
    DaoAuthenticationProvider authenticationProvider(){
        
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(userPrincipalDetailsService);
        
        return daoAuthenticationProvider;
        
    }
    
}
