package com.nanoo.library.clientweb.beans.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 23/11/2019 - 23:20
 */
@Getter @Setter
@NoArgsConstructor
public class ClientBean implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
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
    
}
