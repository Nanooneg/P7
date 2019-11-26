package com.nanoo.library.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MManagementBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MManagementBookApplication.class, args);
	}

}
