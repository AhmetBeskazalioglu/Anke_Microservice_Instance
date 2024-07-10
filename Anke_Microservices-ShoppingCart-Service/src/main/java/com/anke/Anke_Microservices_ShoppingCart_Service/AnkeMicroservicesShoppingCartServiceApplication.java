package com.anke.Anke_Microservices_ShoppingCart_Service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class AnkeMicroservicesShoppingCartServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkeMicroservicesShoppingCartServiceApplication.class, args);
	}
}
