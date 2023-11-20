package com.pernudo.microservice_tracker.service;

import com.pernudo.microservice_tracker.model.Element;
import reactor.core.publisher.Flux;

public interface ElementsService {
    Flux<Element> elementPriceMax(double priceMax);
}
