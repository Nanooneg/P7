package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.proxies.FeignProxy;
import com.nanoo.library.clientweb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
    
    private FeignProxy proxy;
    
    @Autowired
    public LoginController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @GetMapping("/login")
    public String loginForm(Model model){
        
        model.addAttribute("user",new UserBean());
        
        return "login";
        
    }
    
    @PostMapping("/login")
    public String loginUser(@ModelAttribute ("user") UserBean user, Model model,
                            HttpServletResponse response, HttpServletRequest request){
    
        String jwtToken = proxy.doLogin(user);
        model.addAttribute("user",user);
        System.out.println(jwtToken);
        
        if (jwtToken.length() > 0) {
            response.addCookie(CookieUtil.generateCookie(jwtToken));
            response.addHeader(CookieUtil.COOKIE_NAME,jwtToken);
            return "redirect:/utilisateur/home";
        }else {
            return "login";
        }
        
    }
    
}
