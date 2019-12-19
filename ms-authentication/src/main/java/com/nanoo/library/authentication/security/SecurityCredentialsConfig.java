package com.nanoo.library.authentication.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:24
 */
@EnableWebSecurity
public class SecurityCredentialsConfig extends WebSecurityConfigurerAdapter {
    
    private final UserPrincipalDetailsService userPrincipalDetailsService;
    
    @Autowired
    public SecurityCredentialsConfig(UserPrincipalDetailsService userPrincipalDetailsService) {
        this.userPrincipalDetailsService = userPrincipalDetailsService;
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
                // make sure we use stateless session; session won't be used to store user's state.
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                // handle an authorized attempts
                /*.exceptionHandling().authenticationEntryPoint((req, rsp, e) -> rsp.sendError(HttpServletResponse.SC_UNAUTHORIZED))
                .and()*/
                // Add a filter to validate user credentials and add token in the response header
                .addFilter(new JwtUsernameAndPasswordAuthenticationFilter(authenticationManager()))
                // authorization requests config
                .authorizeRequests()
                // allow all who are accessing "auth" service
                .antMatchers(HttpMethod.POST,"/auth/**").permitAll()
                // allow all who are accessing "book" service TODO get back client authorization to /book/consult/**
                .antMatchers("/book/consult/**").hasAnyRole(ADMIN,EMPLOYEE)
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
                .anyRequest().authenticated();
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
