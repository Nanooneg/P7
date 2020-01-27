package com.nanoo.library.apibatch.config;

import com.nanoo.library.apibatch.model.Loan;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author nanoo
 * @create 27/01/2020 - 15:03
 */
@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    private JobBuilderFactory jobBuilderFactory;
    private StepBuilderFactory stepBuilderFactory;
    private ItemReader<Loan> loanRepositoryReader;
    private ItemWriter<Loan> loanItemWriter;
    private ItemProcessor<Loan,Loan> loanStatusItemProcessor;
    
    @Autowired
    public SpringBatchConfig(JobBuilderFactory jobBuilderFactory,
                             StepBuilderFactory stepBuilderFactory,
                             ItemReader<Loan> loanRepositoryReader,
                             ItemWriter<Loan> loanItemWriter,
                             ItemProcessor<Loan, Loan> loanStatusItemProcessor) {
        
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
        this.loanRepositoryReader = loanRepositoryReader;
        this.loanItemWriter = loanItemWriter;
        this.loanStatusItemProcessor = loanStatusItemProcessor;
    }
    
    @Bean
    public Job loanStatusJob() {
        Step updateStatusStep = stepBuilderFactory
                .get("UPDATE-STATUS")
                .<Loan,Loan>chunk(100) //TODO
                .reader(loanRepositoryReader)
                .processor(loanStatusItemProcessor)
                .writer(loanItemWriter)
                .build();
        
        return jobBuilderFactory
                .get("STATUS")
                .start(updateStatusStep)
                .build();
    }
    
}
