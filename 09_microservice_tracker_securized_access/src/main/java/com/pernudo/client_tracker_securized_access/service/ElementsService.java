package com.pernudo.client_tracker_securized_access.service;

import com.pernudo.client_tracker_securized_access.model.Element;
import reactor.core.publisher.Flux;

public interface ElementsService {
    Flux<Element> elementPriceMax(double priceMax);
}
