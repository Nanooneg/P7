package com.nanoo.library.emeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EmEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmEurekaServerApplication.class, args);
	}

}
