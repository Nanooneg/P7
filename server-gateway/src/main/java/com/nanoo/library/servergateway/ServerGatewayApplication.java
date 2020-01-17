package com.nanoo.library.servergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServerGatewayApplication {
	
	/*@Bean
	DiscoveryClientRouteDefinitionLocator dynamicsRoutes (ReactiveDiscoveryClient reactiveDiscoveryClient,
														  DiscoveryLocatorProperties discoveryLocatorProperties){
		return new DiscoveryClientRouteDefinitionLocator(reactiveDiscoveryClient,discoveryLocatorProperties);
	}*/
	
	public static void main(String[] args) {
		SpringApplication.run(ServerGatewayApplication.class, args);
	}
	
}
