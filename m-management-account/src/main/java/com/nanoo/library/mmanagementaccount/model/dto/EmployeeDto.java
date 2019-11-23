package com.nanoo.library.mmanagementaccount.model.dto;

import com.nanoo.library.mmanagementaccount.model.entities.Address;
import com.nanoo.library.mmanagementaccount.model.enums.Gender;
import com.nanoo.library.mmanagementaccount.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 23/11/2019 - 00:29
 */
@Getter @Setter
@NoArgsConstructor
public class EmployeeDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String lastName;
    private String firstName;
    private Date birthDate;
    private Gender gender;
    private String phoneNumber;
    private String email;
    private Address address;
    private Role role;
    private Long employeeNumber;
    private Long socialNumber;

}
