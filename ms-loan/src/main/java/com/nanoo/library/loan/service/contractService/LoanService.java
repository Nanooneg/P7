package com.nanoo.library.loan.service.contractService;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
public interface LoanService {
    
    List<LoanWithAccountInfoDto> getLoanList();
    
    List<LoanWithBookInfoDto> getUserLoanList(int userId, String loanProperty);
    
    LoanWithBookInfoDto extendLoan(int loanId);
    
    ClientDto editAccountInfo(ClientDto clientDto);
    
    int editLoanStatus();
    
    Map<String,Date> getOutdatedLoansEmailAccount();
}
