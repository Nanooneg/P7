package com.nanoo.library.loan.model.entities;

import com.nanoo.library.loan.model.enums.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 23/11/2019 - 17:01
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Book implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    private Integer id;
    
    @Column(length = 50, nullable = false)
    private String title;
    
    @ManyToOne
    private Library library;
    
    @Enumerated(EnumType.STRING)
    @Column(length = 20, nullable = false)
    private Condition condition;
    
    @OneToMany(mappedBy = "book")
    private Set<Loan> loans;
}
