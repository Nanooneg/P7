package com.nanoo.library.mmanagementaccount;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class MManagementAccountApplication {

	public static void main(String[] args) {
		SpringApplication.run(MManagementAccountApplication.class, args);
	}

}
