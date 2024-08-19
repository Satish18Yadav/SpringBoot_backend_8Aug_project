package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Product;

import java.util.List;

public interface ProductService {

    public Product getProductById(Long id);


    public Product createProduct(String title,
                                 String description,
                                 String price,
                                 String category,
                                 String image);

    public List<Product> getAllProducts();
}

