package com.nanoo.library.mmanagementaccount.model.entities;

import com.nanoo.library.mmanagementaccount.model.enums.City;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 21/11/2019 - 15:34
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Address implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(nullable = false)
    private int number;
    @Column(length = 50, nullable = false)
    private String street;
    @Column(name = "postal_code", length = 5, nullable = false)
    private int postalCode;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private City city;

    
}
