package com.pernudo.microservice_crud_reactive_products_db_functional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories(basePackages = "repository")
@SpringBootApplication
public class MicroserviceCrudReactiveProductsFunctionalDB {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCrudReactiveProductsFunctionalDB.class, args);
    }

}