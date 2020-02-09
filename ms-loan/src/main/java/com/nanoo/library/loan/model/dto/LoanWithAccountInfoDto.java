package com.nanoo.library.loan.model.dto;

import com.nanoo.library.commonpackage.model.Status;
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
public class LoanWithAccountInfoDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private Integer id;
    private ClientDto client;
    private Date loanDate;
    private Date expectedReturnDate;
    private Date effectiveReturnDate;
    private boolean extended;
    private Status status;
    
}
