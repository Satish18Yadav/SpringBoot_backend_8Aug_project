package com.satish.shopsy.productservice8aug.model;


import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Integer Id;
    private String title;
    private String Description;
    private double price;
    public String imageURL;
    private Category category;


}
