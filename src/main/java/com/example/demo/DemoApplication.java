package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;
import manager.DemoManager;

@SpringBootApplication
@Slf4j
public class DemoApplication {
	
	@Autowired
	private static DemoManager demo;
	
	@Bean
	public RestTemplate restTemplate() {
	    return new RestTemplate();
	}

	public static void main(String[] args) {
		System.out.println("App started!");
		SpringApplication.run(DemoApplication.class, args);
		demo.handleHello("Hello, World!");
	}
}
