package com.anke.Anke_Microservices_Discovey_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer // Bu uygulamanın bir Eureka sunucusu olduğunu belirtir.
@SpringBootApplication
public class AnkeMicroservicesDiscoveyServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkeMicroservicesDiscoveyServerApplication.class, args);
	}

}
