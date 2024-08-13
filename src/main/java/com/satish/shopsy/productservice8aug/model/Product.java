package com.satish.shopsy.productservice8aug.model;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    String title;
    String description;
    private double price;
    public String imageURL;
}
