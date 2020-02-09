package com.nanoo.library.loan.web.controller;

import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.CopyBookDto;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author nanoo
 * @create 09/02/2020 - 18:52
 */
@RestController
public class LoanCreateOrFinishController {
  
  private LoanService loanService;
  
  @Autowired
  public LoanCreateOrFinishController(LoanService loanService) {
    this.loanService = loanService;
  }
  
  @PutMapping("/create")
  public LoanWithAccountInfoDto createLoan(@RequestBody CopyBookDto copyBookDto,
                                           @RequestBody ClientDto clientDto) {
    
    return loanService.createLoan(copyBookDto, clientDto);
    
  }
  
  @PutMapping("/return/{loanId}")
  public LoanWithAccountInfoDto returnLoan(@PathVariable int loanId){
    
    return loanService.returnLoan(loanId);
    
  }
  
}
