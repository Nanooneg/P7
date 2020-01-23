package com.nanoo.library.loan.service.implService;

import com.nanoo.library.commonpackage.model.Status;
import com.nanoo.library.loan.database.ClientRepository;
import com.nanoo.library.loan.database.LoanRepository;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
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
    private final ClientRepository clientRepository;
    private final LoanMapper loanMapper;
    
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, ClientRepository clientRepository, LoanMapper loanMapper) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
        this.loanMapper = loanMapper;
    }
    
    @Override
    public List<LoanWithAccountInfoDto> getLoanList() {
        List<LoanWithAccountInfoDto> loanWithAccountInfoDtos =  new ArrayList<>();
        
        List<Loan> loans = loanRepository.findAll();
        
        for (Loan loan : loans){
            loanWithAccountInfoDtos.add(loanMapper.fromLoanToDtoWithAccountInfo(loan));
        }
        
        return loanWithAccountInfoDtos;
    }
    
    @Override
    public List<LoanWithBookInfoDto> getUserLoanList(int userId,String loanProperty){
        List<LoanWithBookInfoDto> loanWithBookInfoDtos =  new ArrayList<>();
        
        List<Loan> loans = clientRepository.findAllLoanByClientId(userId);
    
        if (!loanProperty.equalsIgnoreCase("selection")){
            for (Loan loan : loans){
                loanWithBookInfoDtos.add(loanMapper.fromLoanToDtoWithBookInfo(loan));
            }
        }else {
            for (Loan loan : loans){
                if (loan.getStatus() != Status.FINISH){
                    loanWithBookInfoDtos.add(loanMapper.fromLoanToDtoWithBookInfo(loan));
                }
            }
        }
    
        return loanWithBookInfoDtos;
    }
    
}
