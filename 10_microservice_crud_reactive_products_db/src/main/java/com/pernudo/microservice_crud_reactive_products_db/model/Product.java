package com.pernudo.microservice_crud_reactive_products_db.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(value = "products")
public class Product implements Persistable<Integer> {

    //id_product
    @Id
    @Column("id_product")
    private int idProduct;
    private String name;
    private String category;
    private double price;
    private int stock;
    @Transient
    private boolean newProduct;

    @Override
    public Integer getId() {
        return idProduct;
    }

    @Override
    public boolean isNew() {
        return newProduct;
    }
}
