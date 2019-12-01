package com.nanoo.library.clientweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 30/11/2019 - 21:31
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String loginForm(){
        
        return "Login";
        
    }
    
}
