package com.sweetshop.sweetshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.sweetshop.sweetshop.repositories")
@EntityScan(basePackages = "com.sweetshop.sweetshop.entities")
public class SweetshopApplication {

	public static void main(String[] args) {
		SpringApplication.run(SweetshopApplication.class, args);
	}

}
