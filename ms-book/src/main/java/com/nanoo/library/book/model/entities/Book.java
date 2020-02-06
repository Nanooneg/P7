package com.nanoo.library.book.model.entities;

import com.nanoo.library.commonpackage.model.Category;
import com.nanoo.library.commonpackage.model.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:04
 */
@Entity(name = "book")
@Getter @Setter
@NoArgsConstructor
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_book")
    private Integer id;
    
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;
    
    @OneToMany(mappedBy = "book")
    private Set<CopyBook> copies;
    
    @Column(name = "summary", length = 400)
    private String summary;
    
    @ManyToOne
    @JoinColumn(name = "id_cover")
    private Cover cover;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "category", length = 20, nullable = false)
    private Category category;
    
    @Column(name = "registration", nullable = false)
    private Date registration;
}
