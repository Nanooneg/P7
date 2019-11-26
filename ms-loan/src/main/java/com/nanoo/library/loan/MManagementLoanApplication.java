package com.nanoo.library.loan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MManagementLoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(MManagementLoanApplication.class, args);
	}

}
