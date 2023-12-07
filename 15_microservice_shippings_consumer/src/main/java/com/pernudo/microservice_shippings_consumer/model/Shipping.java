package com.pernudo.microservice_shippings_consumer.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "shippings")
public class Shipping {

    //id_shipping
    @Id
    @Column("id_shipping")
    private int idShipping;
    @JsonAlias(value="name")
    private String product;
    @Column("date_shipping")
    private LocalDateTime dateShipping;
    private String address;
    private String status;

}
