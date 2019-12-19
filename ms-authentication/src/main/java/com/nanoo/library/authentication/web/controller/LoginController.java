package com.nanoo.library.authentication.web.controller;

import com.nanoo.library.authentication.database.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
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
    
    /*@PostMapping(value = "/auth/login")
    public ResponseEntity authenticateClient (HttpServletResponse response){
    
        System.out.println("response : " + response);
        
        return new ResponseEntity(HttpStatus.OK);
    }*/
    
}
