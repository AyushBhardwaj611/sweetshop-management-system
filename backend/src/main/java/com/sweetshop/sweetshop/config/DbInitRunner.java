package com.sweetshop.sweetshop.config;

import com.sweetshop.sweetshop.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DbInitRunner {

    @Bean
    CommandLineRunner init(UserRepository repo) {
        return args -> {
            repo.count();
            System.out.println("DB initialized");
        };
    }
}
