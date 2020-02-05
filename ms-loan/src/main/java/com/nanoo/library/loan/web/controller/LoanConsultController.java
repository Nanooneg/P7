package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author nanoo
 * @create 23/11/2019 - 21:00
 */
@RestController
public class LoanConsultController {
    
    private final LoanService loanService;
    
    @Autowired
    public LoanConsultController(LoanService loanService) {
        this.loanService = loanService;
    }
    
    @GetMapping("/consult/allLoans")
    public List<LoanWithAccountInfoDto> listAllLoans (){
        
        return loanService.getLoanList();
        
    }
    
    @GetMapping("/consult/loans/{userId}/{loanProperty}")
    public List<LoanWithBookInfoDto> listUserLoans(@PathVariable int userId, @PathVariable String loanProperty){
        
        return loanService.getUserLoanList(userId,loanProperty);
        
    }
    
    @GetMapping("/get/emails")
    public Map<String,Date> getEmails (){
        
        return loanService.getOutdatedLoansEmailAccount();
        
    }
    
}
