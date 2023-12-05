package com.pernudo.microservice_order_producer.controller;

import com.pernudo.microservice_order_producer.model.Order;
import com.pernudo.microservice_order_producer.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping(value = "save")
    public ResponseEntity<Void> newOrder(@RequestBody Order order){
        try{
            orderService.registerOrder(order);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch(Exception ex){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }

}
