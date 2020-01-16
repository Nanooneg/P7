package com.nanoo.library.clientweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author nanoo
 * @create 11/12/2019 - 15:53
 */
@Controller
public class HomeController {
    
    @GetMapping({"/home","/index","/"})
    public String home(){
        
        return "home";
        
    }
    
}
