package com.satish.shopsy.productservice8aug.model;


import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer Id;

    private String title;
    private double price;
    private Category category;
    private String Description;

    public String imageURL;



}
