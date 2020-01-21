package com.nanoo.library.loan.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 21/01/2020 - 11:26
 */
@Getter @Setter
@NoArgsConstructor
public class LoanWithBookInfoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private BookDto book;
    private Integer accountId;
    private Date loanDate;
    private Date expectedReturnDate;
    private boolean extended;
    private String status;
    
}
