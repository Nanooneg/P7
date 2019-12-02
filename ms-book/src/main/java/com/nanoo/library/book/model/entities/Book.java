package com.nanoo.library.book.model.entities;

import com.nanoo.library.book.model.enums.Category;
import com.nanoo.library.book.model.enums.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:04
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length = 50, nullable = false)
    private String title;
    
    @ManyToMany
    @JoinTable(name = "books_authors",
               joinColumns = @JoinColumn(name = "id_book"),
               inverseJoinColumns = @JoinColumn(name = "id_author"))
    private Set<Author> authors;
    
    @Column(length = 400)
    private String summary;
    
    @ManyToOne(cascade = CascadeType.ALL)
    private Cover cover;
    
    @ManyToOne
    @JoinColumn(name = "id_library")
    private Library library;
    
    @Column(name = "dewey_code", nullable = false)
    private String deweyCode;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Category category;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Condition condition;
    
    @Column(nullable = false)
    private boolean available;
    
}
