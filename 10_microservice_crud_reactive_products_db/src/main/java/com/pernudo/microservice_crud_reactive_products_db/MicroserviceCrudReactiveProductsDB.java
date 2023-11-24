package com.pernudo.microservice_crud_reactive_products_db;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@EnableR2dbcRepositories(basePackages = "repository")
@SpringBootApplication
public class MicroserviceCrudReactiveProductsDB {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceCrudReactiveProductsDB.class, args);
    }

}