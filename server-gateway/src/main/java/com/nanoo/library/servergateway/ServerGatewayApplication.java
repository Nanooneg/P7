package com.nanoo.library.servergateway;

import com.nanoo.library.servergateway.filters.RedirectEditUriFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
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
	
	@Bean
	RouteLocator gatewayRoutes (RouteLocatorBuilder routeLocatorBuilder){
        System.out.println("Gateway Routes configuration bean");
        return routeLocatorBuilder.routes()
                /*.route(r->r
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
						.id("server-consistency-manager"))*/
                .build();
        
    }
	
}
