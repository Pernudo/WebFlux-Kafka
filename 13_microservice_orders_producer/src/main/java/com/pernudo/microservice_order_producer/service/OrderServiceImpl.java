package com.pernudo.microservice_order_producer.service;

import com.pernudo.microservice_order_producer.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class OrderServiceImpl implements OrderService {

    @Value("${topic}")
    String topic;
    @Autowired
    KafkaTemplate<String, Order> kafkaTemplate;

    @Override
    public void registerOrder(Order order) {
        CompletableFuture<SendResult<String, Order>> future = kafkaTemplate.send(topic, order);
        future.whenCompleteAsync((r,t) -> {
            if(t != null){
                throw new RuntimeException();
            }
            System.out.println("Se ha registrado el pedido " + r.getProducerRecord().value().getName() +
                    " en el tópico " + r.getRecordMetadata().topic());
        });
    }
}
