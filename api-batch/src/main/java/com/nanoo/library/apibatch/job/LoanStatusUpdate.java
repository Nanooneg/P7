package com.nanoo.library.apibatch.job;

import com.nanoo.library.apibatch.authentication.CredentialBatch;
import com.nanoo.library.apibatch.web.FeignProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
     * This method get an accessToken with his own credentials and ask ms-loan to update loan status
     *
     * @return a list of mail attached to loan with new 'outdated' status
     */
    List<String> updateStatus(){
        List<String> customersEmail;
    
        logger.info("*** LoanStatusUpdate task begin ***");
        
        String accessToken = proxy.doLogin(new CredentialBatch());
        customersEmail = proxy.doLoanStatusUpdate(accessToken);
    
        logger.info("*** {} loan(s) updated ***",customersEmail.size());
    
        return customersEmail;
        
    }

}
