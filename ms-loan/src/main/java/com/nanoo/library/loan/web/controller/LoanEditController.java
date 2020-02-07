package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.LoanWithCopyBookInfoDto;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public LoanWithCopyBookInfoDto extendLoan(@PathVariable("loanId") int loanId){
        
        return loanService.extendLoan (loanId);
        
    }
    
    @GetMapping("/loanStatus")
    public int updateStatus(){
        
        return loanService.editLoanStatus();
        
    }
    
    @PutMapping("/account")
    public ClientDto editAccountInfo (@RequestBody ClientDto clientDto){
        
        return loanService.editAccountInfo(clientDto);
        
    }
    
}
