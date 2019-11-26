package com.nanoo.library.loan.model.entities;

import com.nanoo.library.loan.model.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 23/11/2019 - 17:01
 */
@Entity
@Getter @Setter
@NoArgsConstructor
public class Loan implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    @ManyToOne
    private Book book;
    
    @ManyToOne
    private Account account;
    
    @Column(name = "loan_date", nullable = false)
    private Date loanDate;
    
    @Column(name = "expected_return_date", nullable = false)
    private Date expectedReturnDate;
    
    @Column(nullable = false)
    private boolean extended;
    
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;
}
