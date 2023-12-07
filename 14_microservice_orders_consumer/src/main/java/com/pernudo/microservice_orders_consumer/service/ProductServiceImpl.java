package com.pernudo.microservice_orders_consumer.service;

import com.pernudo.microservice_orders_consumer.model.Order;
import com.pernudo.microservice_orders_consumer.model.Product;
import com.pernudo.microservice_orders_consumer.repository.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.converter.StringJsonMessageConverter;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductsRepository productsRepository;

    @Override
    public Flux<Product> listProducts() {
        return productsRepository.findAll()//Flux<Product>
                .delayElements(Duration.ofSeconds(1));//Flux<Product>
    }

    @Override
    public Flux<Product> listProductsByCategory(String category) {
        return productsRepository.findByCategory(category)//Flux<Product>
                .delayElements(Duration.ofSeconds(1));//Flux<Product>
    }

    @Override
    public Mono<Product> productById(int id) {
        return productsRepository.findById(id);//Mono<Product>
    }

    @Override
    public Mono<Void> saveProduct(Product product) {
        return productById(product.getIdProduct())//Mono<Product>
                .switchIfEmpty(Mono.just(product).flatMap(p -> productsRepository.save(p)))//Mono<Product>
                .then();//Mono<Void>
    }

    @Override
    public Mono<Product> deleteProduct(int id) {
        return productById(id)//Mono<Product>
                .flatMap(p -> productsRepository.deleteById(id)//Mono<Void>
                        .then(Mono.just(p))//Mono<Product>
                );//Mono<Product>
    }

    @Override
    public Mono<Product> updatePrice(int id, double price) {
        return productById(id)//Mono<Product>
                .flatMap(p -> {
                    p.setPrice(price);
                    return productsRepository.save(p);//Mono<Product>
                });//Mono<Product>
    }


    @KafkaListener(topics = "${topic}", groupId = "${groupA}")
    public void orderManagement(Order order){
        productById(order.getIdProduct()) //Mono<Product>
                .flatMap(product -> {
                  product.setStock(product.getStock() - order.getUnits());
                  return productsRepository.save(product); //Mono<Product>
                }) //Mono<Product>
                .subscribe();
    }

    //To avoid the error JsonDeserializer between com.pernudo.microservice_orders_producer.model.Order and com.pernudo.microservice_orders_consumer.model.Order
    @Bean
    public StringJsonMessageConverter jsonConverter() {
        return new StringJsonMessageConverter();
    }

}
