package com.nanoo.library.clientweb.beans.user;

import com.nanoo.library.clientweb.beans.enums.Gender;
import com.nanoo.library.clientweb.beans.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author nanoo
 * @create 20/01/2020 - 11:34
 */
@Getter @Setter
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
    
}
