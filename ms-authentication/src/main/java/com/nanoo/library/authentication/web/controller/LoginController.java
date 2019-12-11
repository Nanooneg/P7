package com.nanoo.library.authentication.web.controller;

import com.nanoo.library.authentication.database.UserRepository;
import com.nanoo.library.authentication.model.LoginViewModel;
import com.nanoo.library.authentication.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanoo
 * @create 09/12/2019 - 16:27
 */
@RestController
public class LoginController {
    
    private final UserRepository userRepository;
    
    @Autowired
    public LoginController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    //TODO send httpServletResponse with cookie inside
    @PostMapping(value = "/auth/login")
    public User authenticateClient (@RequestParam("user")LoginViewModel user){
    
        System.out.println(user);
        System.out.println(userRepository.findByUsername(user.getUsername()));
        
        return userRepository.findByUsername(user.getUsername());
    }
    
}
