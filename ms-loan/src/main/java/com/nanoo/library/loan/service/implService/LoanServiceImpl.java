package com.nanoo.library.loan.service.implService;

import com.nanoo.library.loan.database.LoanRepository;
import com.nanoo.library.loan.model.dto.LoanDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.model.entities.Loan;
import com.nanoo.library.loan.model.mapper.LoanMapper;
import com.nanoo.library.loan.service.contractService.LoanService;
import com.nanoo.library.loan.web.proxy.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
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
    private final FeignProxy proxy;
    
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, LoanMapper loanMapper, FeignProxy proxy) {
        this.loanRepository = loanRepository;
        this.loanMapper = loanMapper;
        this.proxy = proxy;
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
    
    @Override
    public List<LoanWithBookInfoDto> getUserLoanList(int userId,String token){
        List<LoanWithBookInfoDto> loanDtos =  new ArrayList<>();
        
        List<Loan> loans = loanRepository.findAllByAccountId(userId);
    
        for (Loan loan : loans){
            LoanWithBookInfoDto loanWithBookInfoDto = loanMapper.fromLoanToDtoWithBookInfo(loan);
            loanWithBookInfoDto.setBook(proxy.getBookInfo(token,loan.getBookId()));
            loanDtos.add(loanWithBookInfoDto);
        }
    
        return loanDtos; //TODO write code in userhome to test feature
    }
}
