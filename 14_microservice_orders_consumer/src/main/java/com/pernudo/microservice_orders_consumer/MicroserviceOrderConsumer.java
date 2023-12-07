package com.pernudo.microservice_orders_consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories(basePackages = "repository")
@SpringBootApplication
public class MicroserviceOrderConsumer {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceOrderConsumer.class, args);
    }

}