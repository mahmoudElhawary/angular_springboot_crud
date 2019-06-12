package com.example.app;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.example.app.model.Customer;

@SpringBootApplication
public class MultiLanguageApplication{

	public static void main(String[] args) {
		SpringApplication.run(MultiLanguageApplication.class, args);
		create()  ;
	}

	public static void create() {
		Customer customer =new Customer() ;
		customer.setId(1);
		customer.setFirstName("mahmoud");
		customer.setLastName("elhawary");
		customer.setEmail("mahmoudelhawary@yahoo.com");
		customer.setCreateDate(new Date());
		customer.setUpdateDate(new Date());
		customer.setPhoneNumber("01152190697");
	}
	@Bean
	public CorsFilter corsFilter() {

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true); // you USUALLY want this
		config.addAllowedOrigin("*");
		config.addAllowedHeader("*");
		config.addAllowedMethod("OPTIONS");
		config.addAllowedMethod("HEAD");
		config.addAllowedMethod("GET");
		config.addAllowedMethod("PUT");
		config.addAllowedMethod("POST");
		config.addAllowedMethod("DELETE");
		config.addAllowedMethod("PATCH");
		source.registerCorsConfiguration("/**", config);
		return new CorsFilter(source);
	}
}
