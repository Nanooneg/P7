package com.nanoo.library.mmanagementbook.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Set;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:06
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Author implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @ManyToMany(mappedBy = "authors")
    private Set<Book> books;
    
    @Column(name = "birth_date")
    private Date birthDate;
    
    @Column(name = "death_date")
    private Date deathDate;
    
}
