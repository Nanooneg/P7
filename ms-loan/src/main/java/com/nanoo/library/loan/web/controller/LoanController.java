package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.LoanDto;
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
public class LoanController {
    
    private final LoanService loanService;
    
    @Autowired
    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }
    
    @GetMapping("/loans")
    public List<LoanDto> listAllLoans (){
        
        return loanService.getLoanList();
        
    }
    
    @GetMapping("/loans/{userId}")
    public List<LoanWithBookInfoDto> listUserLoans(@PathVariable int userId, @RequestHeader("Authorization") String token){
        
        return loanService.getUserLoanList(userId,token);
        
    }
}
