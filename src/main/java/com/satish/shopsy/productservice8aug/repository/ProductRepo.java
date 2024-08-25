package com.satish.shopsy.productservice8aug.repository;

import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product,Integer> {

   List<Product> findAll();
//    List<Product> findByCategory(Category category);


    Product findProductById(Integer id);
    //Product findProductByDescription(String description);

    //create a Product
    Product save(Product p);

}

