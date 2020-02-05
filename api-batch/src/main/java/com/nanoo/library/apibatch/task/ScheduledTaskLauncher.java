package com.nanoo.library.apibatch.task;

import com.nanoo.library.apibatch.authentication.CredentialBatch;
import com.nanoo.library.apibatch.job.CustomerRevival;
import com.nanoo.library.apibatch.job.LoanStatusUpdate;
import com.nanoo.library.apibatch.web.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author nanoo
 * @create 05/02/2020 - 12:09
 */
@Service
@EnableScheduling
@EnableAsync
public class ScheduledTaskLauncher {
    
    private LoanStatusUpdate loanStatusUpdate;
    private CustomerRevival customerRevival;
    private FeignProxy proxy;
    
    @Autowired
    public ScheduledTaskLauncher(LoanStatusUpdate loanStatusUpdate, CustomerRevival customerRevival, FeignProxy proxy) {
        this.loanStatusUpdate = loanStatusUpdate;
        this.customerRevival = customerRevival;
        this.proxy = proxy;
    }
    
    
    /**
     * Scheduled task run every minutes for the demo
     * (cron="0 3 * * * ?") prod context : run task every days at 03:00 am
     *
     * First, get a security token with technical account and call for 2 jobs :
     * - update loan status
     * - revive customers with outdated loans
     *
     */
    @Scheduled(cron="* * * * * ?")
    public void runScheduledTask(){
    
        String accessToken = proxy.doLogin(new CredentialBatch());
    
        loanStatusUpdate.updateStatus(accessToken);
        customerRevival.reviveCustomer(accessToken);
        
    }
}
