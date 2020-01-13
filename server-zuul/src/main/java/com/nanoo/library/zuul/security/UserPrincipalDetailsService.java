package com.nanoo.library.zuul.security;

import com.nanoo.library.zuul.database.UserRepository;
import com.nanoo.library.zuul.model.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 25/11/2019 - 13:36
 */
@Service
public class UserPrincipalDetailsService implements UserDetailsService {
    
    private final UserRepository userRepository;
    
    @Autowired
    public UserPrincipalDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    /**
     * Locates the user based on the username. In the actual implementation, the search
     * may possibly be case sensitive, or case insensitive depending on how the
     * implementation instance is configured. In this case, the <code>UserDetails</code>
     * object that comes back may have a username that is of a different case than what
     * was actually requested..
     *
     * @param username the username identifying the user whose data is required.
     * @return a fully populated user record (never <code>null</code>)
     *
     * @throws UsernameNotFoundException if the user could not be found or the user has no
     *                                   GrantedAuthority
     */
    @Override
    public UserDetails loadUserByUsername(String username) {
    
        User user = userRepository.findByUsername(username);
    
        if (user == null) {
            throw new UsernameNotFoundException("No user found for "+ username + ".");
        }
        
        return new UserPrincipal(user);
        
    }
}
