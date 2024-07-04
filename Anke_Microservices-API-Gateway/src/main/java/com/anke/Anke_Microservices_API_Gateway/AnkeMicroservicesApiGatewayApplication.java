package com.anke.Anke_Microservices_API_Gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class AnkeMicroservicesApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkeMicroservicesApiGatewayApplication.class, args);
	}

}
