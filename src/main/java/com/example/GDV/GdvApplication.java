package com.example.GDV;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class GdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(GdvApplication.class, args);
	}

}
