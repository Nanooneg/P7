package com.nanoo.library.commonsecurity;

import lombok.Getter;
import lombok.Setter;

/**
 * @author nanoo
 * @create 18/01/2020 - 12:27
 */
@Getter @Setter
public class JwtConfig {
    
    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final int EXPIRATION = 24*60*60;
    public static final String SECRET = "JwtSecretKey";
    
}