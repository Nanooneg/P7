package com.nanoo.library.mmanagementbook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MManagementBookApplication {

	public static void main(String[] args) {
		SpringApplication.run(MManagementBookApplication.class, args);
	}

}
