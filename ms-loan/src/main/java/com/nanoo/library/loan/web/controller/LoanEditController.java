package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public LoanWithBookInfoDto extendLoan(@PathVariable("loanId") int loanId){
        
        return loanService.extendLoan (loanId);
        
    }
    
    @PostMapping("/account")
    public HttpStatus editAccountInfo (@RequestBody ClientDto clientDto){
        
        loanService.editAccountInfo(clientDto);
        
        return HttpStatus.OK; // TODO
    }
    
}
