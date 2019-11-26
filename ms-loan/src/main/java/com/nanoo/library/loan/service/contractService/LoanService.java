package com.nanoo.library.loan.service.contractService;

import com.nanoo.library.loan.model.dto.LoanDto;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
public interface LoanService {
    
    List<LoanDto> getLoanList();
    
}
