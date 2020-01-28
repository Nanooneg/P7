package com.nanoo.library.loan.service.contractService;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.model.entities.Loan;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
public interface LoanService {
    
    List<LoanWithAccountInfoDto> getLoanList();
    
    List<LoanWithBookInfoDto> getUserLoanList(int userId, String loanProperty);
    
    LoanWithBookInfoDto extendLoan(int loanId);
    
    void editAccountInfo(ClientDto clientDto);
    
    List<String> editLoanStatus();
}
