package com.nanoo.library.serverconsistencymanager.model.beans.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 29/01/2020 - 15:38
 */
@Getter @Setter
@NoArgsConstructor
public class ClientLightBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
    private String password;
    
}
