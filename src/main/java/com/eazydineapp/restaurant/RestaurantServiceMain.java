package com.eazydineapp.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * EazyDineApp Restaurant Microservice
 * @author Harini Balakrishnan
 *
 */
@SpringBootApplication
@ComponentScan
@Configuration
@EnableConfigurationProperties
public class RestaurantServiceMain {
	
	//Spring Boot App
	public static void main(String[] args) {
		SpringApplication.run(RestaurantServiceMain.class, args);
	}
}
