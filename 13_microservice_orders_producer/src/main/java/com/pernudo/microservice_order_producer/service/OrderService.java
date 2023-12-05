package com.pernudo.microservice_order_producer.service;

import com.pernudo.microservice_order_producer.model.Order;

public interface OrderService {

    void registerOrder (Order order);

}
