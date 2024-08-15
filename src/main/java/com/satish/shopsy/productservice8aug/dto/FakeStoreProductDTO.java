package com.satish.shopsy.productservice8aug.dto;


import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter /*and*/ @Setter
public class FakeStoreProductDTO {
    private int id;
    private String title;
    private String price;
    private Category category;
    private String description;
    private List<String> images;

}
