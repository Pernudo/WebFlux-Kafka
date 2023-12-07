package com.pernudo.microservice_shippings_consumer.service;

import com.pernudo.microservice_shippings_consumer.model.Shipping;
import reactor.core.publisher.Flux;

public interface ShippingService {

    Flux<Shipping> pendings();

}
