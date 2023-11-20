package com.pernudo.client_tracker.service;

import com.pernudo.client_tracker.model.Element;
import reactor.core.publisher.Flux;

public interface ElementsService {
    Flux<Element> elementByPrice(double priceMax);
}
