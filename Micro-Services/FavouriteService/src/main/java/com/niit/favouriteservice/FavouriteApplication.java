package com.niit.favouriteservice;

import com.niit.favouriteservice.filter.UserFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;


import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
//import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
//@EnableEurekaClient
public class FavouriteApplication {

	public static void main(String[] args) {
		SpringApplication.run(FavouriteApplication.class, args);
	}
	@Bean
	public FilterRegistrationBean jwtFilter() {
//    final CorsConfiguration config = new CorsConfiguration();
//
//    config.setAllowCredentials(true);
//    config.addAllowedOrigin("http://localhost:4200");
//    config.addAllowedHeader("*");
//    config.addAllowedMethod("*");
//
//    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//    source.registerCorsConfiguration("/**", config);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
//        config.addAllowedOrigin("*");
		config.addAllowedOriginPattern("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("DELETE");
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean frb=new FilterRegistrationBean();
		frb.setOrder(Ordered.HIGHEST_PRECEDENCE);
		frb.setFilter(new UserFilter());
		frb.setFilter(new CorsFilter(source));
		frb.addUrlPatterns("/movieapp/user-fav/fav/*");
		return frb;
	}
}
