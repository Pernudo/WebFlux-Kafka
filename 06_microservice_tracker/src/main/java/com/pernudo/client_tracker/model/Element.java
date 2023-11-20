package com.pernudo.client_tracker.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Element {
    private String name;
    private String category;
    private double price;
    private String shop;
}
