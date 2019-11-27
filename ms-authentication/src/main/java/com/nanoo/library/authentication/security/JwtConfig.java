package com.nanoo.library.authentication.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:25
 */
@Getter @Setter
public class JwtConfig {
    
    public static final String URI = "/auth/**";
    public static final String HEADER = "Authorization";
    public static final String PREFIX = "Bearer ";
    public static final int EXPIRATION = 24*60*60;
    public static final String SECRET = "JwtSecretKey";
    
}
