package com.example.plateforme;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PlateformeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlateformeApplication.class, args);
	}

    @EnableMethodSecurity
    @Configuration
    public static class securityConfig {

        @Bean
        public static PasswordEncoder passwordEncoder(){
            return new BCryptPasswordEncoder();
        }
    }
}
