package com.nanoo.library.servergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class ServerGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(ServerGatewayApplication.class, args);
	}
	
	/*@Bean
	public RouteLocator myRoutes(RouteLocatorBuilder builder) {
		
		return builder.routes().route(p -> p.path("/**").uri("no://op")).build();
	}*/
	
	/*@Bean
	RouteLocator gatewayRoutes (RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
				.route("consistency-manager" , r->r
						.path("/ms-account/edit/account")
						.filters(f->f
							.setPath("/edit/account"))
						.uri("http://localhost:9101"))
                .route(r->r
						.path("/server-authentication/**")
                        .uri("http://localhost:9100")
                        .id("server-authentication"))
                .route(r->r
                        .path("/ms-account/**")
                        .uri("http://localhost:9001")
                        .id("ms-account"))
                .route(r->r
                        .path("/ms-book/**")
                        .uri("lb://ms-book")
                        .id("ms-book"))
                .route(r->r
                        .path("/ms-loan/**")
                        .uri("http://localhost:9003")
                        .id("ms-loan"))
				.route(r->r
						.path("/ms-consistency-manager/**")
						.uri("http://localhost:9101")
						.id("server-consistency-manager"))
                .build();
    }*/
	
}
