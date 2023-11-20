package com.pernudo.crud_reactive_products.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    private int idProduct;
    private String name;
    private String category;
    private double price;
    private int stock;
}
