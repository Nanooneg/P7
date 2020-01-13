package com.nanoo.library.zuul.database;

import com.nanoo.library.zuul.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nanoo
 * @create 27/11/2019 - 00:09
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    
    User findByUsername(String username);
    
}
