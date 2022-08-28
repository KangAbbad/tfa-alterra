package com.alta.bootcamp.authapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class AuthappApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthappApplication.class, args);
	}

}
