package com.satish.shopsy.productservice8aug.dto;

import com.satish.shopsy.productservice8aug.model.Category;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class createProductRequestDTO {
    private String title;
    private String price;
    private String category;
    private String description;
    private String image; // check this later why was this added
}
