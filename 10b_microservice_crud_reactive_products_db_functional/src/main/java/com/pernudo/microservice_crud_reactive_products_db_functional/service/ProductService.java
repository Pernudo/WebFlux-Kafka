package com.pernudo.microservice_crud_reactive_products_db_functional.service;

import com.pernudo.microservice_crud_reactive_products_db_functional.model.Product;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {
    Flux<Product> listProducts();
    Flux<Product> listProductsByCategory(String category);
    Mono<Product> productById(int id);
    Mono<Void> saveProduct(Product product);
    Mono<Product> deleteProduct(int id);
    Mono<Product> updatePrice(int id, double price);
}
