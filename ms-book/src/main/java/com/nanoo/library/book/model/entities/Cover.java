package com.nanoo.library.book.model.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 22/11/2019 - 23:09
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Cover implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_cover")
    private Integer id;
    
    @Column(name = "title", nullable = false)
    private String title;
    
    @Column(name = "path", nullable = false)
    private String path;
    
}
