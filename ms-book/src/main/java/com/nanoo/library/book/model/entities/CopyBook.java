package com.nanoo.library.book.model.entities;

import com.nanoo.library.commonpackage.model.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 06/02/2020 - 10:16
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class CopyBook implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_copy_book")
    private Integer id;
    
    @Column(name = "available", nullable = false)
    private boolean available;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "condition", length = 20, nullable = false)
    private Condition condition;
    
    @ManyToOne
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;
    
    @ManyToOne
    @JoinColumn(name = "id_library", nullable = false)
    private Library library;
    
}
