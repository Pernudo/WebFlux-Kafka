package com.pernudo.microservice_reactive_names_functional.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.*;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Configuration
public class NamesController {

    @Bean
    public RouterFunction<ServerResponse> getNames(){
        List<String> lstNames = List.of("Annette", "Beatriz", "Carolina", "Diana", "Elena",
                "Fabiola", "Gabriela", "Herminia", "Isabel", "Julia");
        return RouterFunctions.route(RequestPredicates.GET("names"),
                request -> ServerResponse.ok() //BodyBuilder
                        .body(Flux.fromIterable(lstNames)
                                .delayElements(Duration.ofSeconds(1)), String.class) //Mono<ServerResponse>
                ); //RouterFunction<ServerResponse>
    }
}
