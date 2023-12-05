package com.pernudo.microservice_order_producer.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Order {

    private int idProduct;
    private String name;
    private int units;
    private String address;

}
