package com.pernudo.microservice_shippings_consumer.controller;

import com.pernudo.microservice_shippings_consumer.model.Shipping;
import com.pernudo.microservice_shippings_consumer.service.ShippingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class Shippingcontroller {

    @Autowired
    ShippingService shippingService;

    public ResponseEntity<Flux<Shipping>> ShippingsPendings(){
        return new ResponseEntity<>(shippingService.pendings(), HttpStatus.OK);
    }

}
