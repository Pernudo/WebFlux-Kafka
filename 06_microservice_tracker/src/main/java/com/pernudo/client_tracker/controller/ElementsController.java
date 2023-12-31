package com.pernudo.client_tracker.controller;

import com.pernudo.client_tracker.model.Element;
import com.pernudo.client_tracker.service.ElementsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
public class ElementsController {
    @Autowired
    ElementsService elementsService;

    @GetMapping(value = "elements")
    public ResponseEntity<Flux<Element>> elemetsPrice(@RequestParam("price") double priceMax){
        return new ResponseEntity<>(elementsService.elementPriceMax(priceMax), HttpStatus.OK);
    }

}
