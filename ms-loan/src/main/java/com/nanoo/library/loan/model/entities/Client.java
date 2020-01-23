package com.nanoo.library.loan.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/01/2020 - 10:57
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Client implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @Column(nullable = false)
    private String email;
    
    @Column(name = "client_number", nullable = false)
    private Long clientNumber;
    
    @OneToMany(mappedBy = "client")
    private Set<Loan> loans;
    
}
