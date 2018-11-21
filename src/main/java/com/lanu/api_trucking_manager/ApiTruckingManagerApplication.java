package com.lanu.api_trucking_manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ApiTruckingManagerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiTruckingManagerApplication.class, args);
    }
}
