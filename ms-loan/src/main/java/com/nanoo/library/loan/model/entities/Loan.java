package com.nanoo.library.loan.model.entities;

import com.nanoo.library.commonpackage.model.Status;
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
    
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @ Column(name = "id_loan")
    private Integer id;
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_copy_book", nullable = false)
    private CopyBook copyBook;
    
    @ManyToOne
    @JoinColumn(name = "id_account", nullable = false)
    private Client client;
    
    @Column(name = "loan_date", nullable = false)
    private Date loanDate;
    
    @Column(name = "expected_return_date", nullable = false)
    private Date expectedReturnDate;
    
    @Column(name = "effective_return_date")
    private Date effectiveReturnDate;
    
    @Column(name = "extended", nullable = false)
    private boolean extended;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
}
