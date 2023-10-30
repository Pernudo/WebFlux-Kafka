package com.pernudo.microservice_reactive_names.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@RestController
public class NamesController {

    @GetMapping(value = "names")
    public Flux<String> getNames(){
        List<String> lstNames = List.of("Annette", "Beatriz", "Carolina", "Diana", "Elena",
                "Fabiola", "Gabriela", "Herminia", "Isabel", "Julia");
        return Flux.fromIterable(lstNames)
                .delayElements(Duration.ofSeconds(2));
    }

}
