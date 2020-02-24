package com.nanoo.library.authentication.database;

import com.nanoo.library.authentication.model.entities.User;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 25/11/2019 - 13:17
 */
@Service
public class DbInit implements CommandLineRunner {
    
    private Logger logger = LoggerFactory.getLogger(DbInit.class);
    
    private static final String PASSWORD = "456456";
    
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Autowired
    public DbInit(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    /**
     * Callback used to run the bean.
     * This method create users and save them in DB at the ms launch.
     *
     * @param args incoming main method arguments
     */
    @Override
    public void run(String... args) {
        
        User admin = new User();
        admin.setId(1);
        admin.setUsername("arnaudlaval33@gmail.com");
        admin.setPassword(passwordEncoder.encode(PASSWORD));
        admin.setActive(true);
        admin.setRoles("CLIENT");
        admin.setPermissions("");
    
        User client = new User();
        client.setId(2);
        client.setUsername("admin@mail.fr");
        client.setPassword(passwordEncoder.encode(PASSWORD));
        client.setActive(true);
        client.setRoles("ADMIN");
        client.setPermissions("");
    
        User employee = new User();
        employee.setId(3);
        employee.setUsername("employee@mail.fr");
        employee.setPassword(passwordEncoder.encode(PASSWORD));
        employee.setActive(true);
        employee.setRoles("EMPLOYEE");
        employee.setPermissions("");
    
        User technicalBatch = new User();
        technicalBatch.setId(4);
        technicalBatch.setUsername("technical-batch");
        technicalBatch.setPassword(passwordEncoder.encode(PASSWORD));
        technicalBatch.setActive(true);
        technicalBatch.setRoles("TECHNICAL");
        technicalBatch.setPermissions("");
    
        User technicalConsistencyManager = new User();
        technicalConsistencyManager.setId(5);
        technicalConsistencyManager.setUsername("technical-consistency-manager");
        technicalConsistencyManager.setPassword(passwordEncoder.encode(PASSWORD));
        technicalConsistencyManager.setActive(true);
        technicalConsistencyManager.setRoles("TECHNICAL");
        technicalConsistencyManager.setPermissions("");
    
        List<User> users = Arrays.asList(admin,client,employee,technicalBatch,technicalConsistencyManager);
        
        try{
            userRepository.saveAll(users);
        }catch (Exception e){
            logger.error(e.getMessage());
        }
        
    }
    
}
