package com.nanoo.library.authentication.web.controller;

import com.nanoo.library.authentication.database.UserRepository;
import com.nanoo.library.authentication.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
    
    @PutMapping("/edit/credential")
    public User editCredentials (@RequestBody User user){
    
    
        Optional<User> oldUser = userRepository.findById(user.getId());
        
        if (oldUser.isPresent()) {
            User existingUser = oldUser.get();
            existingUser.setUsername(user.getUsername());
            if (user.getPassword() != null)
                existingUser.setPassword(passwordEncoder.encode(user.getPassword()));
            userRepository.save(existingUser);
        }

        Optional<User> newUserAccount = userRepository.findById(user.getId());

        return newUserAccount.orElse(null);
    }
    
}
