package com.nanoo.library.clientweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author nanoo
 * @create 11/12/2019 - 13:11
 */
@Controller
@RequestMapping("/utilisateur")
public class UserController {
    
    @GetMapping("/home")
    public String displayUserDashBoard (){
        
        return "userHome";
        
    }
    
}
