package com.pernudo.microservice_crud_reactive_products_db_mongodb.repository;

import com.pernudo.microservice_crud_reactive_products_db_mongodb.model.Product;
import org.springframework.data.mongodb.repository.DeleteQuery;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsRepository extends ReactiveMongoRepository<Product, Integer> {

    Flux<Product> findByCategory(String category);

    Mono<Void> deleteByName(String name);

    @DeleteQuery("{ 'price':{$lt:?0} }")
    Mono<Void> deleteByPriceMax(double priceMax);

}
