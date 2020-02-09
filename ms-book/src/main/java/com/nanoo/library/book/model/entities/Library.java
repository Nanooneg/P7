package com.nanoo.library.book.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:08
 */
@Entity(name = "library")
@Getter @Setter
@NoArgsConstructor
public class Library implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_library")
    private Integer id;
    
    @Column(name = "name", nullable = false)
    private String name;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_address")
    private Address address;
    
    @Column(name = "phone_number", length = 10, nullable = false)
    private String phoneNumber;
    
    @OneToMany(mappedBy = "library")
    private Set<CopyBook> copies;
    
}
