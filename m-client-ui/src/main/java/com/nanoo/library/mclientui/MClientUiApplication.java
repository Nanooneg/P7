package com.nanoo.library.mclientui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.nanoo.library.mclientui")
public class MClientUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(MClientUiApplication.class, args);
	}

}
