package com.nanoo.library.commonpackage.security;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 09/12/2019 - 18:23
 */
public class JwtTokenUtils {
    
    private JwtTokenUtils() {
    }
    
    /**
     * This method generate a cookie with token as value
     *
     * @param token access token to store
     * @return a cookie
     */
    public static Cookie generateCookie (String token){
        
        Cookie cookie = new Cookie(CommonSecurityConfig.HEADER, token);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(999999); // 12 days
        cookie.setDomain("localhost");
        cookie.setPath("/");
        
        return cookie;
    }
    
    /**
     * This method delete cookie stored
     *
     * @param httpServletResponse the HttpServletResponse with cookie to delete
     */
    public static void clear(HttpServletResponse httpServletResponse) {
        Cookie cookie = new Cookie(CommonSecurityConfig.HEADER, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
  
}
