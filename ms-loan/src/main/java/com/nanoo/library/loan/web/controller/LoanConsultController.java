package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author nanoo
 * @create 23/11/2019 - 21:00
 */
@RestController
@RequestMapping("/consult")
public class LoanConsultController {
    
    private final LoanService loanService;
    
    @Autowired
    public LoanConsultController(LoanService loanService) {
        this.loanService = loanService;
    }
    
    @GetMapping("/allLoans")
    public List<LoanWithAccountInfoDto> listAllLoans (){
        
        return loanService.getLoanList();
        
    }
    
    @GetMapping("/loans/{userId}/{loanProperty}")
    public List<LoanWithBookInfoDto> listUserLoans(@PathVariable int userId, @PathVariable String loanProperty){
        
        return loanService.getUserLoanList(userId,loanProperty);
        
    }
    
}
