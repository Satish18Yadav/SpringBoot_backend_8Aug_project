package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    public Product getProductById(Integer id);


    public Product createProduct(String title,
                                 String description,
                                 String price,
                                 String category,
                                 String image);

    public List<Product> getAllProducts();

    Product getProductByIdAndTitle(Integer id, String title);

    public Page<Product> getPaginatedProducts(int pageNo, int pageSize);

    public  Page<Product> getPageBySequence(int pageNo,int pageSize,String sequence);

}

