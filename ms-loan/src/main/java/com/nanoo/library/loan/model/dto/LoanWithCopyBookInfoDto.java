package com.nanoo.library.loan.model.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @author nanoo
 * @create 21/01/2020 - 11:26
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class LoanWithCopyBookInfoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    private Integer id;
    private CopyBookDto copyBook;
    private Date loanDate;
    private Date expectedReturnDate;
    private Date effectiveReturnDate;
    private boolean extended;
    private String status;
    
}

