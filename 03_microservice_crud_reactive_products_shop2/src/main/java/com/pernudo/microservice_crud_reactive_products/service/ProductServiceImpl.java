package com.pernudo.microservice_crud_reactive_products.service;

import com.pernudo.microservice_crud_reactive_products.service.ProductService;
import com.pernudo.microservice_crud_reactive_products.model.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private static final List<Product> lstProducts=new ArrayList<>(List.of(
            new Product(100,"Azúcar","Alimentación",1.10,20),
            new Product(111,"Pan","Alimentación",1.3,10),
            new Product(112,"Esponja","Limpieza",2,20),
            new Product(113,"Sofá","Hogar",80,4),
            new Product(114,"Jarrón","Hogar",40,10),
            new Product(115,"Arina","Alimentación",3,30),
            new Product(116,"Fregona","Limpieza",3.40,6),
            new Product(117,"Cubo","Limpieza",2.5,12)));

    @Override
    public Flux<Product> listProducts() {
        return Flux.fromIterable(lstProducts)//Flux<Product>
                .delayElements(Duration.ofSeconds(1));//Flux<Product>
    }

    @Override
    public Flux<Product> listProductsByCategory(String category) {
        return listProducts()//Flux<Product>
                .filter(p -> p.getCategory().equals(category));//Flux<Product>
    }

    @Override
    public Mono<Product> productById(int id) {
        return listProducts()//Flux<Product>
                .filter(p -> p.getIdProduct() == id)//Flux<Product>
                .next();//Mono<Product>
                //.switchIfEmpty(Mono.just(new Product(110,"Ejemplo","EjemploCat",1.10,20)));//Mono<Product>
    }

    @Override
    public Mono<Void> saveProduct(Product product) {
        return productById(product.getIdProduct())//Mono<Product>
                .switchIfEmpty(Mono.just(product).map(p -> {
                    lstProducts.add(p);
                    return p;
                }))//Mono<Product>
                .then();//Mono<Void>
    }

    @Override
    public Mono<Product> deleteProduct(int id) {
        return productById(id)//Mono<Product>
                .map(p -> {
                    lstProducts.removeIf(m -> m.getIdProduct() == id);
                    return p;
                });//Mono<Product>
    }

    @Override
    public Mono<Product> updatePrice(int id, double price) {
        return productById(id)//Mono<Product>
                .map(p -> {
                    p.setPrice(price);
                    return p;
                });//Mono<Product>
    }
}
