package com.nanoo.library.account;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MManagementAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MManagementAccountApplication.class, args);
	}

}
