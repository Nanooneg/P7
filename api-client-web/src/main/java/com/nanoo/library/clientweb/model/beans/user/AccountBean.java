package com.nanoo.library.clientweb.model.beans.user;

import com.nanoo.library.commonpackage.model.Gender;
import com.nanoo.library.commonpackage.model.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author nanoo
 * @create 20/01/2020 - 11:34
 */
@Getter @Setter @ToString
@NoArgsConstructor
public class AccountBean {
    
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
