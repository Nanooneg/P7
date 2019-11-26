package com.nanoo.library.loan.service.implService;

import com.nanoo.library.loan.database.LoanRepository;
import com.nanoo.library.loan.model.dto.LoanDto;
import com.nanoo.library.loan.model.entities.Loan;
import com.nanoo.library.loan.model.mapper.LoanMapper;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:58
 */
@Service
public class LoanServiceImpl implements LoanService {
    
    private final LoanRepository loanRepository;
    private final LoanMapper loanMapper;
    
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
    }
    
    @Override
    public List<LoanDto> getLoanList() {
        List<LoanDto> loanDtos =  new ArrayList<>();
        
        List<Loan> loans = loanRepository.findAll();
        
        for (Loan loan : loans){
            loanDtos.add(loanMapper.fromLoanToDto(loan));
        }
        
        return loanDtos;
    }
}
