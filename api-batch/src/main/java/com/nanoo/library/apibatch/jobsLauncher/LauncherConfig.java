package com.nanoo.library.apibatch.jobsLauncher;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author nanoo
 * @create 27/01/2020 - 17:11
 */
@Component
@EnableScheduling
public class LauncherConfig {
    
    private Logger logger = LoggerFactory.getLogger(LauncherConfig.class);
    
    private Job job;
    private JobLauncher jobLauncher;
    
    @Autowired
    public LauncherConfig(Job job, JobLauncher jobLauncher) {
        this.job = job;
        this.jobLauncher = jobLauncher;
    }
    
    @Scheduled(cron="* * * * * ?")
    public void loadLoanStatusJob() throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {
    
        Map<String, JobParameter> params = new HashMap<>();
        params.put("time",new JobParameter(System.currentTimeMillis()));
    
        JobParameters jobParameters = new JobParameters(params);
        
        JobExecution jobExecution = jobLauncher.run(job,jobParameters);
        while (jobExecution.isRunning()) System.out.println("*** job is running ***");
        
        logger.info("***Job status : " + jobExecution.getStatus().toString() + " ***");
        
    }
}
