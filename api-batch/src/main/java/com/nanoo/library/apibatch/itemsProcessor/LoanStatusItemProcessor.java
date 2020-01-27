package com.nanoo.library.apibatch.itemsProcessor;

import com.nanoo.library.apibatch.model.Loan;
import com.nanoo.library.commonpackage.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author nanoo
 * @create 27/01/2020 - 15:43
 */
@Component
public class LoanStatusItemProcessor implements ItemProcessor<Loan,Loan> {
    
    private Logger logger = LoggerFactory.getLogger(LoanStatusItemProcessor.class);
   
    @Override
    public Loan process(Loan loan){
    
        System.out.println("*** ItemProcessorExecution before Status condition ***");
    
        if (loan.getExpectedReturnDate().before(new Date())){
            
            loan.setStatus(Status.OUTDATED);
            logger.trace("*** ItemProcessorExecution ***");
            System.out.println("*** ItemProcessorExecution ***");
            
        }
        
        return loan;
    }
    
}
