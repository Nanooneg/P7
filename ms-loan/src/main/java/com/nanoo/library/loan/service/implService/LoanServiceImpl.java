package com.nanoo.library.loan.service.implService;

import com.nanoo.library.commonpackage.model.Status;
import com.nanoo.library.loan.database.ClientRepository;
import com.nanoo.library.loan.database.LoanRepository;
import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithBookInfoDto;
import com.nanoo.library.loan.model.entities.Client;
import com.nanoo.library.loan.model.entities.Loan;
import com.nanoo.library.loan.model.mapper.ClientMapper;
import com.nanoo.library.loan.model.mapper.LoanMapper;
import com.nanoo.library.loan.service.contractService.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:58
 */
@Service
public class LoanServiceImpl implements LoanService {
    
    private static final int LOAN_DAYS_DURATION = 14;
    
    private final LoanRepository loanRepository;
    private final ClientRepository clientRepository;
    private final LoanMapper loanMapper;
    private final ClientMapper clientMapper;
    
    @Autowired
    public LoanServiceImpl(LoanRepository loanRepository, ClientRepository clientRepository, LoanMapper loanMapper, ClientMapper clientMapper) {
        this.loanRepository = loanRepository;
        this.clientRepository = clientRepository;
        this.loanMapper = loanMapper;
        this.clientMapper = clientMapper;
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
        loans.sort(Comparator.comparing(Loan::getLoanDate,Comparator.reverseOrder()));
    
        if (loanProperty.equalsIgnoreCase("all")){
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
    
    @Override
    public LoanWithBookInfoDto extendLoan(int loanId) {
        Optional<Loan> loanWithBookInfo = loanRepository.findById(loanId);
        
        if (loanWithBookInfo.isPresent()){
            Loan existingLoanWithBookInfo = loanWithBookInfo.get();
            if (existingLoanWithBookInfo.isExtended()){
                return null;
            }else {
                existingLoanWithBookInfo.setExtended(true);
                existingLoanWithBookInfo.setExpectedReturnDate(
                        extendExpectedReturnDate(existingLoanWithBookInfo.getExpectedReturnDate()));
                if (existingLoanWithBookInfo.getStatus().equals(Status.OUTDATED)) {
                    existingLoanWithBookInfo.setStatus(Status.ONGOING);
                } // TODO compare date to handle "not extensible" loan
                return loanMapper.fromLoanToDtoWithBookInfo(loanRepository.save(existingLoanWithBookInfo));
            }
        }
        
        return null;
    }
    
    private Date extendExpectedReturnDate (Date oldDate){
        Calendar c = Calendar.getInstance();
        c.setTime(oldDate);
        c.add(Calendar.DAY_OF_WEEK,LOAN_DAYS_DURATION);
        return c.getTime();
    }
    
    @Override
    public void editAccountInfo(ClientDto clientDto) {
    
        Optional<Client> oldClient = clientRepository.findById(clientDto.getId());
        
        if (oldClient.isPresent())
            clientRepository.save(clientMapper.fromDtoToClient(clientDto));
        
    }
    
    @Override
    public List<String> editLoanStatus() {
        
        List<Loan> outDatedLoans = loanRepository.findAllByStatusAndReturnDate(Status.ONGOING);
        List<String> customersEmail = new ArrayList<>();
    
        for (Loan loan : outDatedLoans){
            
            customersEmail.add(loan.getClient().getEmail());
            loan.setStatus(Status.OUTDATED);
            
        }
        
        loanRepository.saveAll(outDatedLoans);
        
        return customersEmail;
    }
}
