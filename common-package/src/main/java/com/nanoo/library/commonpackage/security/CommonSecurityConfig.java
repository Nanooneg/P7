package com.nanoo.library.commonpackage.security;


/**
 * @author nanoo
 * @create 18/01/2020 - 12:27
 */
public class CommonSecurityConfig {
    
    private CommonSecurityConfig() {
    }
    
    /* Config */
    public static final String HEADER = "Authorization";
    public static final int EXPIRATION = 7; // in days
    public static final String SECRET = "JwtSecretKey";
    public static final String CLAIM_NAME = "role";
    
    /* Roles */
    public static final String ROLE_ADMIN = "ADMIN";
    public static final String ROLE_EMPLOYEE = "EMPLOYEE";
    public static final String ROLE_CLIENT = "CLIENT";
    public static final String ROLE_TECHNICAL = "TECHNICAL";
    
}