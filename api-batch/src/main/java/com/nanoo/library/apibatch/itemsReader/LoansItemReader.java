package com.nanoo.library.apibatch.itemsReader;

import com.nanoo.library.apibatch.database.LoanRepository;
import com.nanoo.library.apibatch.model.Loan;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author nanoo
 * @create 27/01/2020 - 17:09
 */
@Component
public class LoansItemReader {
    
    private LoanRepository loanRepository;
    
    @Autowired
    public LoansItemReader(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    
    @Bean
    public ItemReader<Loan> loanRepositoryReader (){
    
        System.out.println("*** loanRepositoryReader ***");
        
        RepositoryItemReader<Loan> repositoryItemReader = new RepositoryItemReader<>();
        repositoryItemReader.setRepository(loanRepository);
        HashMap<String, Sort.Direction> sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.DESC);
        repositoryItemReader.setSort(sorts);
        
        return repositoryItemReader;
        
    }
    
}
