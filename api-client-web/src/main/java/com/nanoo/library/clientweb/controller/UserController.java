package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.user.AccountBean;
import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.proxies.FeignProxy;
import com.nanoo.library.clientweb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author nanoo
 * @create 11/12/2019 - 13:11
 */
@Controller
@RequestMapping("/utilisateur")
public class UserController {
    
    private FeignProxy proxy;
    
    @Autowired
    public UserController(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    @GetMapping("/home")
    public String displayUserDashBoard (HttpServletRequest request, Model model){
    
        String token = CookieUtil.getToken(request);
        
        if (token == null){
            model.addAttribute("user",new UserBean());
            return "login";
        }
    
        AccountBean accountInfo = proxy.getAccountInfo(token);
        model.addAttribute("account",accountInfo);
        
        return "userHome";
        
    }
    
}
