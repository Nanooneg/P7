package com.nanoo.library.mmanagementloan.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/11/2019 - 16:52
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    
    @Column(length = 50, unique = true, nullable = false)
    private String email;
    
    @OneToMany(mappedBy = "account")
    private Set<Loan> loans;
    
}
