package com.nanoo.library.serverconsistencymanager.model.beans.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 24/01/2020 - 16:18
 */
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private String username;
    private String password;
    
}
