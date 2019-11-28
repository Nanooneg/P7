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
    
    public static final String PASSWORD = "456456";
    
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
        
        User admin = new User();
        admin.setId(1);
        admin.setUsername("admin@mail.fr");
        admin.setPassword(passwordEncoder.encode(PASSWORD));
        admin.setActive(true);
        admin.setRoles("ADMIN");
        admin.setPermissions("");
    
        User client = new User();
        client.setId(2);
        client.setUsername("client@mail.fr");
        client.setPassword(passwordEncoder.encode(PASSWORD));
        client.setActive(true);
        client.setRoles("CLIENT");
        client.setPermissions("");
    
        User employee = new User();
        employee.setId(3);
        employee.setUsername("employee@mail.fr");
        employee.setPassword(passwordEncoder.encode(PASSWORD));
        employee.setActive(true);
        employee.setRoles("EMPLOYEE");
        employee.setPermissions("");
    
        List<User> users = Arrays.asList(admin,client,employee);
        
        userRepository.saveAll(users);
        
    }
    
}
