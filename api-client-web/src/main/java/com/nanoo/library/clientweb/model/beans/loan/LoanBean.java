package com.nanoo.library.clientweb.model.beans.loan;

import com.nanoo.library.clientweb.model.beans.book.CopyBookLoanBean;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

/**
 * @author nanoo
 * @create 21/01/2020 - 13:47
 */
@Getter @Setter
@NoArgsConstructor
@ToString
public class LoanBean {
    
    private Integer id;
    private CopyBookLoanBean copyBook;
    private Date loanDate;
    private Date expectedReturnDate;
    private Date effectiveReturnDate;
    private boolean extended;
    private String status;
    
}
