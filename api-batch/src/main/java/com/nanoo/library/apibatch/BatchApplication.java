package com.nanoo.library.apibatch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;

@SpringBootApplication
@EnableFeignClients("com.nanoo.library.apibatch")
@EnableEurekaClient
public class BatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(BatchApplication.class, args);
	}
	
	
	/**
	 * Mail template
	 */
	@Bean
	public SimpleMailMessage templateSimpleMessage() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setText("Bonjour," +
				"\n\nLa date de retour pour votre livre était le : %s" +
				"\nVous avez la possibilité, si vous ne l'avez pas encore fait, de prolonger la durée de votre emprunt de 4 semaines." +
				"\nSinon, pensez à ramener le livre à votre bibliothèque au plus vite pour éviter une pénalité" +
				"\n\n\t\t\t\tBibliothèque de Bordeaux - Ceci est un envoi automatique, merci de ne pas y répondre.");
		return message;
	}
	
}
