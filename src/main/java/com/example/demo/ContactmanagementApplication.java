package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@ComponentScan("com.example")
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.model")
@EnableCaching
@SpringBootApplication
public class ContactmanagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactmanagementApplication.class, args);
	}

}
