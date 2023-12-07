package com.pernudo.microservice_shippings_consumer.service;

import com.pernudo.microservice_shippings_consumer.model.Shipping;
import com.pernudo.microservice_shippings_consumer.repository.ShippingsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;

@Service
public class ShippingServiceImpl implements ShippingService {

    @Autowired
    ShippingsRepository shippingsRepository;

    @Override
    public Flux<Shipping> pendings() {
        return shippingsRepository.findByPendings();
    }

    @KafkaListener(topics = "${topic}", groupId = "${groupB}")
    public void shippingManagement(Shipping shipping){
        shipping.setDateShipping(LocalDateTime.now());
        shipping.setStatus("pending");
        shippingsRepository.save(shipping).subscribe();
    }
}
