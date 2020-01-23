package com.nanoo.library.loan.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:43
 */
@Getter @Setter
@NoArgsConstructor
public class ClientDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private String lastName;
    private String firstName;
    private String email;
    private Long clientNumber;
    
}
