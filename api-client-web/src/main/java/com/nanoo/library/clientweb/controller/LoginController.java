package com.nanoo.library.clientweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 26/11/2019 - 15:25
 */
@Controller
public class LoginController {
    
    @GetMapping("/login")
    public String login(){
        
        return "login";
        
    }
    
}
