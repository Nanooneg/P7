package com.nanoo.library.serverconsistencymanager.model.beans.user;

import com.nanoo.library.commonpackage.model.Gender;
import com.nanoo.library.commonpackage.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 24/01/2020 - 15:42
 */
@Getter @Setter
@NoArgsConstructor
public class ClientBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private AddressBean address;
    private Role role;
    private Long clientNumber;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    private String password;
    
}
