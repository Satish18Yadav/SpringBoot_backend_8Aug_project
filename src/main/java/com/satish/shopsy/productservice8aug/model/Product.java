package com.satish.shopsy.productservice8aug.model;
import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
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
    @ManyToOne(cascade={CascadeType.PERSIST})
    private Category category;
    private String Description;

    public String imageURL;

}
