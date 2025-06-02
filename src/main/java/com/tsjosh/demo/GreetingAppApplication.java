package com.tsjosh.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(ApplicationProperties.class)
public class GreetingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingAppApplication.class, args);
	}

}
