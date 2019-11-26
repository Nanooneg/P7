package com.nanoo.library.clientweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.nanoo.library.clientweb")
@EnableEurekaClient
public class MClientUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MClientUiApplication.class, args);
	}

}
