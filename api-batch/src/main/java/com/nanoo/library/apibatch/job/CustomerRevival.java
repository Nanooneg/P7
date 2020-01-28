package com.nanoo.library.apibatch.job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author nanoo
 * @create 28/01/2020 - 11:08
 */
@Service
@EnableScheduling
@EnableAsync
public class CustomerRevival {
    
    private JavaMailSender emailSender;
    private SimpleMailMessage templateSimpleMessage;
    private LoanStatusUpdate loanStatusUpdate;
    
    private static final String MAIL_SUBJECT = "Vous êtes en retard pour le retour de votre livre";
    
    @Autowired
    public CustomerRevival(JavaMailSender emailSender, SimpleMailMessage templateSimpleMessage, LoanStatusUpdate loanStatusUpdate) {
        this.emailSender = emailSender;
        this.templateSimpleMessage = templateSimpleMessage;
        this.loanStatusUpdate = loanStatusUpdate;
    }
    
    @Scheduled(cron="* * * * * ?")
    public void runScheduledTask(){
        
        List<String> customersEmail = loanStatusUpdate.updateStatus();
        
        for (String mail : customersEmail){
            
            sendSimpleMessage(mail, getExpectedReturnDate());
            
        }
        
    }
    
    private void sendSimpleMessage(String to, String arg) {
        
        SimpleMailMessage message = new SimpleMailMessage(templateSimpleMessage);
        
        String text = String.format(message.getText(),arg); // TODO

        message.setTo(to);
        message.setSubject(CustomerRevival.MAIL_SUBJECT);
        message.setText(text);
        
        emailSender.send(message);
        
    }
    
    
    private String getExpectedReturnDate (){
        String pattern = "dd MMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.DAY_OF_WEEK,-1);
        
        return simpleDateFormat.format(c.getTime());
        
    }
}
