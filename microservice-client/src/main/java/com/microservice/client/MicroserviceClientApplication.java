package com.microservice.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableFeignClients
@EnableDiscoveryClient
@EnableJpaRepositories
@SpringBootApplication
public class MicroserviceClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceClientApplication.class, args);
	}

}
