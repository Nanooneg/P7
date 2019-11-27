package com.nanoo.library.authentication.database;

import com.nanoo.library.authentication.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 27/11/2019 - 00:09
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    User findByUsername (String username);
    
}
