package com.nanoo.library.apibatch.job;

import com.nanoo.library.apibatch.web.FeignProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

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
    private FeignProxy proxy;
    
    private static final String MAIL_SUBJECT = "Vous êtes en retard pour le retour de votre livre";
    
    @Autowired
    public CustomerRevival(JavaMailSender emailSender, SimpleMailMessage templateSimpleMessage, FeignProxy proxy) {
        this.emailSender = emailSender;
        this.templateSimpleMessage = templateSimpleMessage;
        this.proxy = proxy;
    }
    
    /**
     * This method call ms-loan to get an email list back and send a message to each one
     *
     * @param accessToken security token
     */
    public void reviveCustomer (String accessToken){
    
        Map<String,Date> customersEmailAndExpectedReturnDate = proxy.getOutdatedLoanEmails(accessToken);
        
        for (Map.Entry<String,Date> entry: customersEmailAndExpectedReturnDate.entrySet()){
            sendSimpleMessage(entry.getKey(),getExpectedReturnDateFormatted(entry.getValue()));
        }
        
    }
    
    /**
     * This method build and send an email with a template
     *
     * @param to mail address of recipient
     * @param arg argument to insert in email body : expected return date
     */
    private void sendSimpleMessage(String to, String arg) {
        
        SimpleMailMessage message = new SimpleMailMessage(templateSimpleMessage);
        
        String text = String.format(Objects.requireNonNull(message.getText()),arg);

        message.setTo(to);
        message.setSubject(CustomerRevival.MAIL_SUBJECT);
        message.setText(text);
        
        emailSender.send(message);
        
    }
    
    /**
     * This method format the expected return date
     *
     * @param date a date
     * @return a formatted date
     */
    private String getExpectedReturnDateFormatted (Date date){
        String pattern = "dd MMM yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        
        return simpleDateFormat.format(date);
        
    }
}
