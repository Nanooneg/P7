package com.nanoo.library.apibatch.itemsWriter;

import com.nanoo.library.apibatch.database.LoanRepository;
import com.nanoo.library.apibatch.model.Loan;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author nanoo
 * @create 27/01/2020 - 16:06
 */
@Component
public class loanItemWriter implements ItemWriter<Loan> {
    
    private LoanRepository loanRepository;
    
    @Autowired
    public loanItemWriter(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }
    
    @Override
    public void write(List<? extends Loan> loans) throws Exception {
        System.out.println("*** loanItemWriter ***");
        loanRepository.saveAll(loans);
    }
    
}
