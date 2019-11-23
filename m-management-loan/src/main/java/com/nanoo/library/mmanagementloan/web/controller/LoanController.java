package com.nanoo.library.mmanagementloan.web.controller;

import com.nanoo.library.mmanagementloan.model.dto.LoanDto;
import com.nanoo.library.mmanagementloan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 21:00
 */
@RestController
public class LoanController {
    
    private final LoanService loanService;
    
    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    
    @GetMapping("/emprunts")
    public List<LoanDto> listAllLoans (){
        
        return loanService.getLoanList();
        
    }
}
