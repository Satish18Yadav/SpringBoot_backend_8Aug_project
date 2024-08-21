package com.satish.shopsy.productservice8aug.model;


import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product extends  BaseModel implements Serializable {

    private Integer Id;

    private String title;
    private double price;
    private Category category;
    private String Description;

    public String imageURL;



}
