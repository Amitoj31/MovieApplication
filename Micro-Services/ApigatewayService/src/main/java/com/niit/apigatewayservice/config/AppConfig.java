package com.niit.apigatewayservice.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public RouteLocator getRoutes(RouteLocatorBuilder routeLocatorBuilder) {
        return routeLocatorBuilder.routes()
                .route(p -> p.path("/movieapp/authuser/**").uri("http://localhost:9000/"))
                .route(p -> p.path("/movieapp/user-fav/**").uri("http://localhost:9001/"))
                .route(p->p.path("/movieapp/movies/**").uri("http://localhost:9002/"))
                .build();
    }
}