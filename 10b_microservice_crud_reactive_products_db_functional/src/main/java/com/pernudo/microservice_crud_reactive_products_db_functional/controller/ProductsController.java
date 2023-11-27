package com.pernudo.microservice_crud_reactive_products_db_functional.controller;

import com.pernudo.microservice_crud_reactive_products_db_functional.model.Product;
import com.pernudo.microservice_crud_reactive_products_db_functional.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

//@CrossOrigin("*")
//@RestController
@Configuration
public class ProductsController {

    @Autowired
    ProductService productService;

    @Bean
    public RouterFunction<ServerResponse> responses(){
        return RouterFunctions.route(RequestPredicates.GET("products"),
            request -> ServerResponse.ok() //BodyBuilder
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.listProducts(), Product.class) //Mono<ServerResponse>
        ) //RouterFunction<ServerResponse>
        .andRoute(RequestPredicates.GET("products/{category}"),
            request -> ServerResponse.ok() //BodyBuilder
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.listProductsByCategory(request.pathVariable("category")), Product.class) //Mono<ServerResponse>
        ) //RouterFunction<ServerResponse>
        .andRoute(RequestPredicates.GET("product"),
            request -> ServerResponse.ok() //BodyBuilder
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(productService.productById(request.queryParam("id").map(Integer::parseInt).get()), Product.class) //Mono<Producto>
        )//RouterFunction<ServerResponse>
        .andRoute(RequestPredicates.POST("save"),
            request -> request.bodyToMono(Product.class) //Mono<Product>
                .flatMap(product -> {
                    product.setNewProduct(true);
                    return productService.saveProduct(product); //Mono<Void>
                })
                .flatMap(v -> ServerResponse.ok() //BodyBuilder
                    .contentType(MediaType.TEXT_EVENT_STREAM)
                    .build() //Mono<ServerResponse>
                )//Mono<ServerResponse>
        )//RouterFunction<ServerResponse>
        .andRoute(RequestPredicates.DELETE("delete"),
            request -> productService.deleteProduct(request.queryParam("id").map(Integer::parseInt).get()) //Mono<Producto>
                .flatMap(product -> ServerResponse.ok() //BodyBuilder
                    .contentType(MediaType.TEXT_EVENT_STREAM)
                    .bodyValue(product) //Mono<ServerResponse>
                )
                .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND) //BodyBuilder
                    .contentType(MediaType.TEXT_EVENT_STREAM)
                    .build() //Mono<ServerResponse>
                )
        )//RouterFunction<ServerResponse>
        .andRoute(RequestPredicates.PUT("update"),
            request -> productService.updatePrice(
                            request.queryParam("id").map(Integer::parseInt).get(),
                            request.queryParam("price").map(Double::parseDouble).get()) //Mono<Producto>
                .flatMap(product -> ServerResponse.ok() //BodyBuilder
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .bodyValue(product) //Mono<ServerResponse>
                )
                .switchIfEmpty(ServerResponse.status(HttpStatus.NOT_FOUND) //BodyBuilder
                        .contentType(MediaType.TEXT_EVENT_STREAM)
                        .build() //Mono<ServerResponse>
                )
        );//RouterFunction<ServerResponse>
    }

    @Bean
    CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsWebFilter(source);
    }
}
