package com.hans.bet.soccer_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SoccerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoccerServiceApplication.class, args);
	}

}
