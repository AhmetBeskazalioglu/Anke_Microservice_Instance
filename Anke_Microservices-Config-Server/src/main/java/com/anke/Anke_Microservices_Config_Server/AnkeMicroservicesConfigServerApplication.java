package com.anke.Anke_Microservices_Config_Server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer // Bu uygulamanın bir Config sunucusu olduğunu belirtir.
@EnableDiscoveryClient // Bu uygulamanın bir Eureka sunucusu olduğunu belirtir.
@SpringBootApplication
public class AnkeMicroservicesConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnkeMicroservicesConfigServerApplication.class, args);
	}

}
