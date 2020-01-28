package com.nanoo.library.apibatch.job;

import com.nanoo.library.apibatch.authentication.CredentialBatch;
import com.nanoo.library.apibatch.web.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author nanoo
 * @create 27/01/2020 - 22:46
 */
@Service
@EnableScheduling
@EnableAsync
public class LoanStatusUpdate {
    
    private FeignProxy proxy;
    
    @Autowired
    public LoanStatusUpdate(FeignProxy proxy) {
        this.proxy = proxy;
    }
    
    public List<String> updateStatus(){
        List<String> customersEmail;
    
        System.out.println("*** LoanStatusUpdate task begin ***");
        
        String accessToken = proxy.doLogin(new CredentialBatch());
        customersEmail = proxy.doLoanStatusUpdate(accessToken);
    
        System.out.println("*** " + customersEmail.size() + " loan(s) updated ***");
        
        return customersEmail;
        
    }

}
