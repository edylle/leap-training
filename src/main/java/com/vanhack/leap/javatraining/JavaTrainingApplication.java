package com.vanhack.leap.javatraining;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class JavaTrainingApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaTrainingApplication.class, args);
	}
}
