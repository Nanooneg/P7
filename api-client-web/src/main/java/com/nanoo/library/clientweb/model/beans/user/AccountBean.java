package com.nanoo.library.clientweb.model.beans.user;

import java.util.Date;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author nanoo
 * @create 20/01/2020 - 11:34
 */
@Data
@NoArgsConstructor
public class AccountBean {
    
    
    private Integer id;
    private String lastName;
    private String firstName;
    private Long clientNumber;
    private AddressBean address;
    private Date birthDate;
    private Date dateOfCreation;
    
    private String phoneNumber;
    private String email;
    private String password;
    
    
}
