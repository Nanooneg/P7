package com.nanoo.library.book.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
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
    
    @ManyToMany(mappedBy = "authors", fetch = FetchType.EAGER)
    private Set<Book> books;
    
    @Column(name = "birth_date")
    private Date birthDate;
    
    @Column(name = "death_date")
    private Date deathDate;
    
    /* Custom getter to return only available books */
    public Set<Book> getAvailableBooks() {
        Set<Book> availableBooks = new HashSet<>();
        
        for (Book book : books){
            if (book.isAvailable()){
                availableBooks.add(book);
            }
        }
        
        return availableBooks;
    }
}
