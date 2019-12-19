package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.proxies.BookProxy;
import com.nanoo.library.clientweb.proxies.LoginProxy;
import com.nanoo.library.clientweb.utils.CookieUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.Objects;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
    
    private final BookProxy bookProxy;
    private final LoginProxy loginProxy;
    private CookieUtil cookieUtil;
    
    @Autowired
    public LoginController(BookProxy bookProxy, LoginProxy loginProxy) {
        this.bookProxy = bookProxy;
        this.loginProxy = loginProxy;
    }
    
    @GetMapping("/login")
    public String loginForm(Model model){
        
        model.addAttribute("user",new UserBean());
        
        return "Login";
        
    }
    
    @PostMapping("/login")
    public String doLogin(Model model, @ModelAttribute UserBean user,
                          HttpServletRequest request){
        
        cookieUtil = new CookieUtil();

        // authenticate user and jwt token is add to ResponseHeader
        //ClientBean loggedUser = bookProxy.authenticateClient(user);
        bookProxy.authenticateClient(user);
        //System.out.println("response entity : " + responseEntity);
        
        //String token = cookieUtil.cookieValueFromResponse(response, "Authorization");
        
        return "Home";
    }
    
    
}
