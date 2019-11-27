package com.nanoo.common.security;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author nanoo
 * @create 26/11/2019 - 18:25
 */
@Getter @Setter
public class JwtConfig {
    
    @Value("${security.jwt.uri:/auth/**}")
    private String uri;
    
    @Value("${security.jwt.header:Authorization}")
    private String header;
    
    @Value("${security.jwt.prefix:Bearer }")
    private String prefix;
    
    @Value("${security.jwt.expiration:#{24*60*60}}")
    private int expiration;
    
    @Value("${security.jwt.secret:JwtSecretKey}")
    private String secret;
    
}
