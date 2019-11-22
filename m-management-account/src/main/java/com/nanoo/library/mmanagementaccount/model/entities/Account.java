package com.nanoo.library.mmanagementaccount.model.entities;

import com.nanoo.library.mmanagementaccount.model.enums.Gender;
import com.nanoo.library.mmanagementaccount.model.enums.Role;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:16
 */
@MappedSuperclass
@Getter @Setter
@NoArgsConstructor
class Account implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name = "last_name", nullable = false)
    private String lastName;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "birth_date", nullable = false)
    private Date birthDate;
    @Enumerated(EnumType.STRING)
    @Column(length = 10, nullable = false)
    private Gender gender;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(length = 50, unique = true, nullable = false)
    private String email;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Address address;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    
}
