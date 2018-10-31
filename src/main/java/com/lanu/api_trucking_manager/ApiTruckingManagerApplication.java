package com.lanu.api_trucking_manager;

import com.lanu.api_trucking_manager.entities.Freight;
import com.lanu.api_trucking_manager.services.FreightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ApiTruckingManagerApplication implements CommandLineRunner {
    @Autowired
    private FreightService freightService;
    public static void main(String[] args) {
        SpringApplication.run(ApiTruckingManagerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Freight freight = new Freight("Kurwa");
        freightService.save(freight);
    }
}
