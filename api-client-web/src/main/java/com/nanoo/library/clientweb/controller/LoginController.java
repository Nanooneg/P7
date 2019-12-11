package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.proxies.BookProxy;
import com.nanoo.library.clientweb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
    
    private final BookProxy bookProxy;
    private CookieUtil cookieUtil;
    
    @Autowired
    public LoginController(BookProxy bookProxy) {
        this.bookProxy = bookProxy;
    }
    
    @GetMapping("/login")
    public String loginForm(Model model){
        
        model.addAttribute("user",new UserBean());
        
        return "login";
        
    }
    
    @PostMapping("/login")
    public String doLogin(Model model, @ModelAttribute UserBean user,
                          HttpServletResponse response,
                          HttpServletRequest request){
        
        cookieUtil = new CookieUtil();
        
        // authenticate user and jwt token is add to ResponseHeader
        bookProxy.authenticateClient(user);
        System.out.println("response : "+ response.getHeader("Authorization"));
        
        String token = response.getHeader("Authorization");
        
        //String token = cookieUtil.cookieValueFromResponse(response, "Authorization");
        System.out.println(token);
        //response.addHeader("Authorization", "Bearer " + token);
        
        return "Home";
    }
    
    @PostMapping("/home")
    public String home (Model model, HttpServletResponse response){
    
        cookieUtil = new CookieUtil();
        
        String token = cookieUtil.cookieValueFromResponse(response, "Authorization");
        System.out.println(token);
        //response.addHeader("Authorization", "Bearer " + token);
        
        return "Home";
    }
    
    
}
