package com.satish.shopsy.productservice8aug.dto;

import com.satish.shopsy.productservice8aug.model.Category;
import lombok.Getter;
import lombok.Setter;


@Getter /*and*/ @Setter
    public class ProductResponseDTO {
    private Integer Id;
    private String title;
    private String Description;
    private double price;
    public String imageURL;
    private Category category;

}
