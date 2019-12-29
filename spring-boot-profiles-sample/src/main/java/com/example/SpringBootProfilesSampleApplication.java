package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootProfilesSampleApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(SpringBootProfilesSampleApplication.class, args);
		System.out.println("DefaultBean : " + context.containsBean("defaultBean"));
		System.out.println("DevBean : " + context.containsBean("devBean"));
		System.out.println("ProductionBean : " + context.containsBean("productionBean"));
	}
}
