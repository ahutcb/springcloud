package com.lg.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient 
public class FileServiceBakApplication {
	public static void main(String[] args) {
		SpringApplication.run(FileServiceBakApplication.class, args);
	}
}