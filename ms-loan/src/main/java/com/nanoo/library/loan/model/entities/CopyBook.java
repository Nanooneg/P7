package com.nanoo.library.loan.model.entities;

import com.nanoo.library.commonpackage.model.Condition;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

/**
 * @author nanoo
 * @create 07/02/2020 - 09:52
 */
@Entity @Getter
@Setter
@NoArgsConstructor
public class CopyBook implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @Column(name = "id_copy_book")
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "condition", length = 20, nullable = false)
    private Condition condition;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_book", nullable = false)
    private Book book;
    
    @OneToMany(mappedBy = "copyBook")
    private Set<Loan> loans;
    
}
