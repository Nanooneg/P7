package com.nanoo.library.clientweb.controller;

import com.nanoo.library.clientweb.beans.user.UserBean;
import com.nanoo.library.clientweb.proxies.LoginProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
    
    private final LoginProxy loginProxy;
    
    @Autowired
    public LoginController(LoginProxy loginProxy) {
        this.loginProxy = loginProxy;
    }
    
    @GetMapping("/login")
    public String loginForm(Model model){
        
        model.addAttribute("user",new UserBean());
        
        return "Login";
        
    }
    
    @PostMapping("/login")
    public String doLogin(@ModelAttribute UserBean user){

        loginProxy.authenticateClient(user);

        return "Home";
    }
    
    
}
