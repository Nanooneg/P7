package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanoo
 * @create 23/01/2020 - 16:00
 */
@RestController
@RequestMapping("/edit")
public class LoanEditController {
    
    private final LoanService loanService;
    
    @Autowired
    public LoanEditController(LoanService loanService) {
        this.loanService = loanService;
    }

    @GetMapping("/extend/loan/{loanId}")
    public LoanWithBookInfoDto extendLoan(@PathVariable("loanId") int loanId){
        
        return loanService.extendLoan (loanId);
        
    }
    
}
