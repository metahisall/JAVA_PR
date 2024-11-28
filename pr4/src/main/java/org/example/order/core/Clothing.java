package org.example.order.core;

import lombok.Builder;
import lombok.Getter;


@Getter
public class Clothing extends Product {
    private String size;

    @Builder
    public Clothing(String name, double price, String size) {
        super(name, price);
        this.size = size;
    }
}
