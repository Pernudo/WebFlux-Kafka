package com.pernudo.microservice_orders_consumer.service;

import com.pernudo.microservice_orders_consumer.model.Product;
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
