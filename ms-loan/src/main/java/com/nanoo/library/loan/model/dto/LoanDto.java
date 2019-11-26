package com.nanoo.library.loan.model.dto;

import com.nanoo.library.loan.model.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:40
 */
@Getter @Setter
@NoArgsConstructor
public class LoanDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private BookDto book;
    private AccountDto account;
    private Date loanDate;
    private Date expectedReturnDate;
    private boolean extended;
    private Status status;
    
}
