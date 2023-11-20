package com.pernudo.client_tracker.service;

import com.pernudo.client_tracker.model.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

@Service
public class ElementsServiceImpl implements ElementsService{
    String url = "http://localhost:8086";
    @Autowired
    WebClient webClient;

    @Override
    public Flux<Element> elementByPrice(double priceMax) {
        return webClient
                .get()
                .uri(url + "/elements?price=" + priceMax)
                .retrieve()
                .bodyToFlux(Element.class);
    }
}
