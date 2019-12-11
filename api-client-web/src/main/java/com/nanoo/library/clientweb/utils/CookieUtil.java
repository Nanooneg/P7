package com.nanoo.library.clientweb.utils;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 09/12/2019 - 18:23
 */
public class CookieUtil {
    
    
    public String cookieValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
    
    public String cookieValueFromResponse(HttpServletResponse response, String name) {
        return response.getHeader(name);
    }
    
    //TODO is a good method to destroy cookie ?
    public void clear(HttpServletResponse httpServletResponse, String name) {
        Cookie cookie = new Cookie(name, null);
        cookie.setPath("/");
        cookie.setHttpOnly(true);
        cookie.setMaxAge(0);
        httpServletResponse.addCookie(cookie);
    }
  
}
