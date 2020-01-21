package com.nanoo.library.clientweb.beans.loan;

import com.nanoo.library.clientweb.beans.book.BookLoanBean;
import com.nanoo.library.clientweb.beans.enums.Status;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

/**
 * @author nanoo
 * @create 21/01/2020 - 13:47
 */
@Getter @Setter
@NoArgsConstructor
public class LoanBean {
    
    private Integer id;
    private BookLoanBean book;
    private Integer accountId;
    private Date loanDate;
    private Date expectedReturnDate;
    private boolean extended;
    private String status;
    
}
