package com.nanoo.library.emconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class EmConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmConfigServerApplication.class, args);
	}

}
