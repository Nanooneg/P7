package com.nanoo.library.loan.service.contractService;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.CopyBookDto;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithCopyBookInfoDto;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
public interface LoanService {

  List<LoanWithAccountInfoDto> getLoanList();

  List<LoanWithCopyBookInfoDto> getUserLoanList(int userId, String loanProperty);

  LoanWithCopyBookInfoDto extendLoan(int loanId);

  ClientDto editAccountInfo(ClientDto clientDto);

  int editLoanStatus();

  Map<String, Date> getOutdatedLoansEmailAccount();

  LoanWithAccountInfoDto createLoan (CopyBookDto copyBookDto, ClientDto clientDto);

  LoanWithAccountInfoDto returnLoan(int loanId);
}
