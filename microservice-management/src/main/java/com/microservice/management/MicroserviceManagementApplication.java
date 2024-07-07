package com.microservice.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableDiscoveryClient
@EnableJpaRepositories
@SpringBootApplication
public class MicroserviceManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroserviceManagementApplication.class, args);
	}

}
