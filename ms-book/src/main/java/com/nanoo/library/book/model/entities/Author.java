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
@Entity(name = "author")
@Getter @Setter
@NoArgsConstructor
public class Author implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_author")
    private Integer id;
    
    @Column(name = "last_name", nullable = false)
    private String lastName;
    
    @Column(name = "first_name", nullable = false)
    private String firstName;
    
    @OneToMany(mappedBy = "author")
    private Set<Book> books;
    
    /* Custom getter to return only available books TODO recast with new mapping*/
    /*public Set<Book> getAvailableBooks() {
        Set<Book> availableBooks = new HashSet<>();
        
        for (Book book : books){
            if (book.isAvailable()){
                availableBooks.add(book);
            }
        }
        
        return availableBooks;
    }*/
}
