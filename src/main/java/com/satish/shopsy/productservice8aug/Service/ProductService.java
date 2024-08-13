package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Product;

public interface ProductService {
    public Product getProductById(Long id);

    public void createProduct();

}

