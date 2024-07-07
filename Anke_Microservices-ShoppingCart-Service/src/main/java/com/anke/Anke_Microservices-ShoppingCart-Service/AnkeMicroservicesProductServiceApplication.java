package com.anke.Anke_Microservices-ShoppingCart-Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AnkeMicroservicesProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkeMicroservicesProductServiceApplication.class, args);
	}

}
