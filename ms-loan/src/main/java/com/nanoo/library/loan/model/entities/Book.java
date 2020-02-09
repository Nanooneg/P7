package com.nanoo.library.loan.model.entities;

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
    
    @Id
    @Column(name = "id_book")
    private Integer id;
    
    @Column(name = "title", length = 50, nullable = false)
    private String title;
    
    @Column(name = "cover", nullable = false)
    private String cover;
    

    
}
