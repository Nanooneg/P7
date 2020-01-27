package com.nanoo.library.authentication.web.controller;

import com.nanoo.library.authentication.database.UserRepository;
import com.nanoo.library.authentication.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanoo
 * @create 24/01/2020 - 16:38
 */
@RestController
public class CredentialEditController {
    
    private UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public CredentialEditController(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    @PostMapping("/edit/credential")
    public HttpStatus editCredentials (@RequestHeader String accessToken, @RequestBody User user){
    
        if (accessToken != null){ // TODO secure enough ?
    
            User existingUser = userRepository.findById(user.getId());
            existingUser.setUsername(user.getUsername());
            if (user.getPassword() != null)
                existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(existingUser);
    
            return HttpStatus.OK; // TODO
        }
        
        return HttpStatus.UNAUTHORIZED;
    }
    
}
