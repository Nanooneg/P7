package com.nanoo.library.commonsecurity.security;


/**
 * @author nanoo
 * @create 18/01/2020 - 12:27
 */
public class CommonSecurityConfig {
    
    private CommonSecurityConfig() {
    }
    
    /* Config */
    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final int EXPIRATION = 24*60*60;
    public static final String SECRET = "JwtSecretKey";
    
    /* Roles */
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_CLIENT = "CLIENT";
    
}