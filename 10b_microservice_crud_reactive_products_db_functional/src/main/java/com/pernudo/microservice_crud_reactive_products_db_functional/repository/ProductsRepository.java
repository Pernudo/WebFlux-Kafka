package com.pernudo.microservice_crud_reactive_products_db_functional.repository;

import com.pernudo.microservice_crud_reactive_products_db_functional.model.Product;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductsRepository extends ReactiveCrudRepository<Product, Integer> {

    Flux<Product> findByCategory(String category);

    @Transactional
    Mono<Void> deleteByName(String name);

    @Transactional
    @Query("delete from products where price > ?")
    Mono<Void> deleteByPriceMax(double priceMax);

}
