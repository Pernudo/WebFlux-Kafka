package com.pernudo.microservice_crud_products.service;

import com.pernudo.microservice_crud_products.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> listProducts();
    List<Product> listProductsByCategory(String category);
    Product productById(int id);
    void saveProduct(Product product);
    Product deleteProduct(int id);
    Product updatePrice(int id, double price);
}
