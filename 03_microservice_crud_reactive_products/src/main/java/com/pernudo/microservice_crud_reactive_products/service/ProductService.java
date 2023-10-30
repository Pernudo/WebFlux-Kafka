package com.pernudo.microservice_crud_reactive_products.service;

import com.pernudo.microservice_crud_reactive_products.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface ProductService {
    Flux<Product> listProducts();
    Flux<Product> listProductsByCategory(String category);
    Mono<Product> productById(int id);
    Mono<Void> saveProduct(Product product);
    Mono<Product> deleteProduct(int id);
    Mono<Product> updatePrice(int id, double price);
}
