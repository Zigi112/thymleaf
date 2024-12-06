package com.example.demo;

import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.thymeleaf.ThymeleafAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@EnableAutoConfiguration
@SpringBootApplication(
		
		exclude= {
				ThymeleafAutoConfiguration.class,
		},
				scanBasePackages = {
						"com.example.config",
				        "com.example.Controllers",
				        "com.example.repository",
				        "com.example.Model"
				    }
		
		)
@EntityScan(basePackages = "com.example.Model")
@EnableJpaRepositories(basePackages = "com.example.repositry") 
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	

}
