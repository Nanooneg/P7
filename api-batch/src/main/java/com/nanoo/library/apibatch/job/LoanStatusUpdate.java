package com.nanoo.library.apibatch.job;

import com.nanoo.library.apibatch.web.FeignProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 27/01/2020 - 22:46
 */
@Service
public class LoanStatusUpdate {
    
    private Logger logger = LoggerFactory.getLogger(LoanStatusUpdate.class);
    
    private FeignProxy proxy;
    
    @Autowired
    public LoanStatusUpdate(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    /**
     *  This method ask ms-loan to update loan status
     *
     * @param accessToken security token
     */
    public void updateStatus(String accessToken){
    
        logger.info("*** LoanStatusUpdate task begin ***");
        
        int updatedAccountNbr = proxy.doLoanStatusUpdate(accessToken);
    
        logger.info("*** {} loan(s) updated ***",updatedAccountNbr);
        
    }
 
}
