package com.satish.shopsy.productservice8aug.dto;

import com.satish.shopsy.productservice8aug.model.Category;
import lombok.Getter;
import lombok.Setter;


@Getter /*and*/ @Setter
    public class ProductResponseDTO {
    private Integer Id;
    private String title;
    private double price;
    private Category category;
    private String Description;
    public String imageURL;


}
