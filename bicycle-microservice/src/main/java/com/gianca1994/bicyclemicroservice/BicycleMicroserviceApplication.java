package com.gianca1994.bicyclemicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BicycleMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BicycleMicroserviceApplication.class, args);
	}

}
