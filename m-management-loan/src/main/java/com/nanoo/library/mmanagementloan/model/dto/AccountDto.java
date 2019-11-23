package com.nanoo.library.mmanagementloan.model.dto;

import com.nanoo.library.mmanagementloan.model.entities.Loan;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:43
 */
@Getter @Setter
@NoArgsConstructor
public class AccountDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String lastName;
    private String firstName;
    private String phoneNumber;
    private String email;
    
}
