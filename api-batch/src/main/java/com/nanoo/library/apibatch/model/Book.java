package com.nanoo.library.apibatch.model;

import com.nanoo.library.commonpackage.model.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author nanoo
 * @create 23/01/2020 - 10:58
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @Column(length = 50, nullable = false)
    private String title;
    
    @Column(length = 400)
    private String summary;
    
    @Column(nullable = false)
    private String cover;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Condition condition;
    
}
