package com.pernudo.microservice_tracker.service;

import com.pernudo.microservice_tracker.model.Element;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ElementsServiceImpl implements ElementsService{
    String url1 = "http://localhost:8083";
    String url2 = "http://localhost:9083";
    @Override
    public Flux<Element> elementPriceMax(double priceMax) {
        Flux<Element> flux1 = catalog(url1, "Shop1");
        Flux<Element> flux2 = catalog(url2, "Shop2");
        return Flux.merge(flux1, flux2) //Flux<Element>
                .filter(e -> e.getPrice() <= priceMax);
    }

    private Flux<Element> catalog(String url, String shop){
        WebClient webClient = WebClient.create(url);
        return webClient
                .get()
                .uri("/products")
                .retrieve()
                .bodyToFlux(Element.class)
                .map(e -> {
                    e.setShop(shop);
                    return e;
                });
    }
}
