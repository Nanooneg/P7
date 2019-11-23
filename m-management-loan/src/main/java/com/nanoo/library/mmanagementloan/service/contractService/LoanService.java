package com.nanoo.library.mmanagementloan.service.contractService;

import com.nanoo.library.mmanagementloan.model.dto.LoanDto;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:56
 */
public interface LoanService {
    
    List<LoanDto> getLoanList();
    
}
