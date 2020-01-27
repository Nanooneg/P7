package com.nanoo.library.clientweb.model.beans.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author nanoo
 * @create 23/11/2019 - 23:20
 */
@Getter @Setter
@NoArgsConstructor
public class ClientBean {
    
    private Integer id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private String gender;
    private String phoneNumber;
    private String email;
    private AddressBean address;
    private String role;
    private Long clientNumber;
    private Date dateOfCreation;
    private Date dateOfUpdate;
    
}
