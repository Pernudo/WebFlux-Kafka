package com.pernudo.microservice_shippings_consumer.repository;

import com.pernudo.microservice_shippings_consumer.model.Shipping;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ShippingsRepository extends ReactiveCrudRepository<Shipping, Integer> {

    @Query("delete from shippings where status = 'pending'")
    Flux<Shipping> findByPendings ();

}
