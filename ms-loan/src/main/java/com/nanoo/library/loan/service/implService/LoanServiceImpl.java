package com.nanoo.library.loan.service.implService;

import com.nanoo.library.commonpackage.model.Status;
import com.nanoo.library.loan.database.ClientRepository;
import com.nanoo.library.loan.database.LoanRepository;
import com.nanoo.library.loan.model.dto.ClientDto;
import com.nanoo.library.loan.model.dto.CopyBookDto;
import com.nanoo.library.loan.model.dto.LoanWithAccountInfoDto;
import com.nanoo.library.loan.model.dto.LoanWithCopyBookInfoDto;
import com.nanoo.library.loan.model.entities.Client;
import com.nanoo.library.loan.model.entities.Loan;
import com.nanoo.library.loan.model.mapper.ClientMapper;
import com.nanoo.library.loan.model.mapper.CopyBookMapper;
import com.nanoo.library.loan.model.mapper.LoanMapper;
import com.nanoo.library.loan.service.contractService.LoanService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 23/11/2019 - 20:58
 */
@Service
public class LoanServiceImpl implements LoanService {
  
  private static final int LOAN_DAYS_DURATION = 28;
  
  private final LoanRepository loanRepository;
  private final ClientRepository clientRepository;
  private final LoanMapper loanMapper;
  private final ClientMapper clientMapper;
  private final CopyBookMapper copyBookMapper;
  
  @Autowired
  public LoanServiceImpl(LoanRepository loanRepository, ClientRepository clientRepository,
    LoanMapper loanMapper, ClientMapper clientMapper,
    CopyBookMapper copyBookMapper) {
    this.loanRepository = loanRepository;
    this.clientRepository = clientRepository;
    this.loanMapper = loanMapper;
    this.clientMapper = clientMapper;
    this.copyBookMapper = copyBookMapper;
  }
  
  @Override
  public List<LoanWithAccountInfoDto> getLoanList() {
    List<LoanWithAccountInfoDto> loanWithAccountInfoDtos = new ArrayList<>();
    
    List<Loan> loans = loanRepository.findAll();
    
    for (Loan loan : loans) {
      loanWithAccountInfoDtos.add(loanMapper.fromLoanToDtoWithAccountInfo(loan));
    }
    
    return loanWithAccountInfoDtos;
  }
  
  @Override
  public List<LoanWithCopyBookInfoDto> getUserLoanList(int userId, String loanProperty) {
    List<LoanWithCopyBookInfoDto> loanWithBookInfoDtos = new ArrayList<>();
    
    List<Loan> loans = loanRepository.findAllLoanByClientId(userId);
    loans.sort(Comparator.comparing(Loan::getLoanDate, Comparator.reverseOrder()));
    
    if (loanProperty.equalsIgnoreCase("all")) {
      for (Loan loan : loans) {
        loanWithBookInfoDtos.add(loanMapper.fromLoanToDtoWithBookInfo(loan));
      }
    } else {
      for (Loan loan : loans) {
        if (loan.getStatus() != Status.FINISH) {
          loanWithBookInfoDtos.add(loanMapper.fromLoanToDtoWithBookInfo(loan));
        }
      }
    }
    
    System.out.println(Arrays.toString(loanWithBookInfoDtos.toArray()));
    
    return loanWithBookInfoDtos;
  }
  
  @Override
  public LoanWithCopyBookInfoDto extendLoan(int loanId) {
    Optional<Loan> loanWithBookInfo = loanRepository.findById(loanId);
    
    if (loanWithBookInfo.isPresent()) {
      Loan existingLoanWithBookInfo = loanWithBookInfo.get();
      if (existingLoanWithBookInfo.isExtended() || !isExtensible(
        existingLoanWithBookInfo.getExpectedReturnDate())) {
        return null;
      } else {
        existingLoanWithBookInfo.setExtended(true);
        existingLoanWithBookInfo.setExpectedReturnDate(
          extendExpectedReturnDate(existingLoanWithBookInfo.getExpectedReturnDate()));
        if (existingLoanWithBookInfo.getStatus().equals(Status.OUTDATED)) {
          existingLoanWithBookInfo.setStatus(Status.ONGOING);
        }
        return loanMapper.fromLoanToDtoWithBookInfo(loanRepository.save(existingLoanWithBookInfo));
      }
    }
    
    return null;
  }
  
  @Override
  public ClientDto editAccountInfo(ClientDto clientDto) {
    
    Optional<Client> oldClient = clientRepository.findById(clientDto.getId());
    
    if (oldClient.isPresent()) {
      clientRepository.save(clientMapper.fromDtoToClient(clientDto));
      Optional<Client> newClientAccount = clientRepository.findById(oldClient.get().getId());
      
      if (newClientAccount.isPresent()) {
        return clientMapper.fromClientToDto(newClientAccount.get());
      }
      
    }
    
    return null;
  }
  
  @Override
  public int editLoanStatus() {
    
    List<Loan> newOutDatedLoans = loanRepository.findAllByStatusAndReturnDate(Status.ONGOING);
    
    for (Loan loan : newOutDatedLoans) {
      
      loan.setStatus(Status.OUTDATED);
      
    }
    
    loanRepository.saveAll(newOutDatedLoans);
    
    return newOutDatedLoans.size();
  }
  
  @Override
  public Map<String, Date> getOutdatedLoansEmailAccount() {
    
    List<Loan> outDatedLoans = loanRepository.findAllByStatusAndReturnDate(Status.OUTDATED);
    Map<String, Date> emailsAndExpectedReturnDate = new HashMap<>();
    
    for (Loan loan : outDatedLoans) {
      
      emailsAndExpectedReturnDate.put(loan.getClient().getEmail(), loan.getExpectedReturnDate());
      
    }
    
    return emailsAndExpectedReturnDate;
  }
  
  @Override
  public LoanWithAccountInfoDto createLoan(CopyBookDto copyBookDto, ClientDto clientDto) {
    
    Loan loan = new Loan();
    
    loan.setClient(clientMapper.fromDtoToClient(clientDto));
    loan.setCopyBook(copyBookMapper.fromDtoToCopyBook(copyBookDto));
    loan.setLoanDate(new Date());
    loan.setExpectedReturnDate(extendExpectedReturnDate(new Date()));
    loan.setExtended(false);
    loan.setStatus(Status.ONGOING);
    
    Loan savedLoan = loanRepository.save(loan);
    
    return loanMapper.fromLoanToDtoWithAccountInfo(savedLoan);
  }
  
  @Override
  public LoanWithAccountInfoDto returnLoan(int loanId) {
    
    Optional<Loan> loan = loanRepository.findById(loanId);
    
    if (loan.isPresent()) {
      
      Loan existingLoan = loan.get();
      existingLoan.setStatus(Status.FINISH);
      existingLoan.setEffectiveReturnDate(new Date());
      
      return loanMapper.fromLoanToDtoWithAccountInfo(loanRepository.save(existingLoan));
    }
    
    return null;
  }
  
  private Date extendExpectedReturnDate(Date oldDate) {
    Calendar c = Calendar.getInstance();
    c.setTime(oldDate);
    c.add(Calendar.DAY_OF_WEEK, LOAN_DAYS_DURATION);
    return c.getTime();
  }
  
  private boolean isExtensible(Date actualExpectedReturnDate) {
    
    return extendExpectedReturnDate(actualExpectedReturnDate).after(new Date());
    
  }
}
