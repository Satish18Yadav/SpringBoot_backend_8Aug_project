package com.satish.shopsy.productservice8aug.dto;


//import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter /*and*/ @Setter
public class FakeStoreProductDTO {
    private Integer id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

}
