package com.pernudo.crud_reactive_products.runner;

import com.pernudo.crud_reactive_products.model.Product;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class TestRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Llamamos al servicio!");
        WebClient webClient = WebClient.create("http://localhost:8083");

/*
        Flux<Product> fluxProducts = webClient
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Product.class);

        fluxProducts.subscribe(System.out::println);
*/

/*
        webClient
                .post()
                .uri("/save")
                .body(Mono.just(new Product(230, "Cepillo", "Limpieza", 1.50, 20)), Product.class)
                .retrieve()
                .bodyToMono(Void.class)
                .doOnTerminate(() -> System.out.println("Alta realizada con éxito."))
                .block();
*/

/*
        Mono<Product> monoProduct = webClient
                .get()
                .uri("/product?id=102")
                .retrieve()
                .bodyToMono(Product.class);

        monoProduct.subscribe(System.out::println);
        monoProduct.switchIfEmpty(Mono.just(new Product()).map(p -> {
            System.out.println("No se ha encontrado producto");
            return p;
        })).block();
 */

        webClient
                .delete()
                .uri("/delete?id=102999")
                .retrieve()
                .onStatus(HttpStatusCode::is4xxClientError, t -> {
                    System.out.println("No se encontró el producto");
                    return Mono.empty();
                })
                .bodyToMono(Product.class)
                .subscribe(System.out::println);





    }
}
