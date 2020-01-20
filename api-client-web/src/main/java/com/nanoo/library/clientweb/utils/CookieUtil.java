package com.nanoo.library.clientweb.utils;

import com.nanoo.library.commonsecurity.CommonSecurityConfig;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 09/12/2019 - 18:23
 */
public class CookieUtil {
    
    private CookieUtil() {
    }
    
    public static Cookie generateCookie (String token){
        
        Cookie cookie = new Cookie(CommonSecurityConfig.HEADER, token);
        cookie.setSecure(false);
        cookie.setHttpOnly(true);
        cookie.setMaxAge(999999); // 12 days
        cookie.setDomain("localhost");
        cookie.setPath("/");
        
        return cookie;
    }
    
    public static String getToken(HttpServletRequest request) {
        Cookie cookie = WebUtils.getCookie(request, CommonSecurityConfig.HEADER);
        return cookie != null ? cookie.getValue() : null;
    }
    
    //TODO is a good method to destroy cookie ?
    public static void clear(HttpServletResponse httpServletResponse, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
  
}
