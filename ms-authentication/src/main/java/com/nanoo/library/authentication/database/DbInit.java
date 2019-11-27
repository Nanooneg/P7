package com.nanoo.library.authentication.database;

import com.nanoo.library.authentication.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author nanoo
 * @create 25/11/2019 - 13:17
 */
@Service
public class DbInit implements CommandLineRunner {
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    /**
     * Callback used to run the bean.
     *
     * @param args incoming main method arguments
     */
    @Override
    public void run(String... args) {

        // Delete all
        //this.userRepository.deleteAll();
        
        User user = new User();
        user.setId(1);
        user.setUsername("admin@mail.fr");
        user.setPassword(passwordEncoder.encode("456456"));
        user.setActive(true);
        user.setRoles("ADMIN");
        user.setPermissions("");
    
        //List<User> users = Arrays.asList(admin);
        
        userRepository.save(user);
        
    }
    
}
