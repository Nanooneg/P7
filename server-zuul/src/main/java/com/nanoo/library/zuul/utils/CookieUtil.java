package com.nanoo.library.zuul.utils;

import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * @author nanoo
 * @create 10/12/2019 - 17:01
 */
public class CookieUtil {
    
    private CookieUtil() {
    }
    
    public static String cookieValue(HttpServletRequest httpServletRequest, String name) {
        Cookie cookie = WebUtils.getCookie(httpServletRequest, name);
        return cookie != null ? cookie.getValue() : null;
    }
    
}
