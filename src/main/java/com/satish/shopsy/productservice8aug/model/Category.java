package com.satish.shopsy.productservice8aug.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Category extends BaseModel {

    private  String title;
    @JsonIgnore
    @OneToMany(mappedBy="category",fetch= FetchType.LAZY,cascade={CascadeType.REMOVE})
    List<Product> products;
}
