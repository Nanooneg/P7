package com.nanoo.library.serverconsistencymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.nanoo.library.serverconsistencymanager")
@EnableEurekaClient
public class ConsistencyManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConsistencyManagerApplication.class, args);
	}

}
