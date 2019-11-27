package com.nanoo.library.authentication.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanoo
 * @create 27/11/2019 - 20:40
 */
@RestController
public class LoginController {
    
    @GetMapping("/login")
    public boolean doLogin(){
        return true;
    }
    
}
