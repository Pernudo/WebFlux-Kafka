package com.pernudo.microservice_crud_reactive_products_db_mongodb.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Document(collection = "products")
public class Product {

    @Id
    private int idProduct;
    private String name;
    private String category;
    private double price;
    private int stock;

}
