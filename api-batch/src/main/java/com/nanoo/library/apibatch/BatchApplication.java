package com.nanoo.library.apibatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import java.util.Properties;

@SpringBootApplication
@EnableFeignClients("com.nanoo.library.apibatch")
@EnableEurekaClient
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
	
	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);
		
		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");
		
		Authenticator authenticator = new Authenticator() {
			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("bibliotheque.de.bordeaux@gmail.com", "Motdepass33");
			}
		};
		
		Session session = Session.getDefaultInstance(props, authenticator);
		mailSender.setSession(session);
		
		return mailSender;
	}
	
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("Bonjour," +
				"\n\nLa date de retour pour votre livre était le : %s" +
				"\nVous avez la possibilité, si vous ne l'avez pas encore fait, de prolonger la durée de votre emprunt de 2 semaines." +
				"\nSinon, pensez à ramener le livre à votre bibliothèque au plus vite pour éviter une pénalité" +
				"\n\nBibliothèque de Bordeaux - Ceci est un envoi automatique, merci de ne pas y répondre.");
		return message;
	}
	
}
