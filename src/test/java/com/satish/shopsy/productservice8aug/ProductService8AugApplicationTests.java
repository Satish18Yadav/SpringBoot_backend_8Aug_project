package com.satish.shopsy.productservice8aug;

import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.repository.CategoryRepo;
import com.satish.shopsy.productservice8aug.repository.ProductRepo;
import com.satish.shopsy.productservice8aug.repository.projection.productProjection;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


import java.util.List;

@SpringBootTest
class ProductService8AugApplicationTests {

    @Autowired
    private ProductRepo productRepo;
    @Autowired
    private CategoryRepo categoryRepo;

    @Test
    @Transactional
    void contextLoads() {

//        List<productProjection> pros = productRepo.getIdAndPriceFromProductTitle("Mototrocatane");
//        System.out.println(pros.size());
//        System.out.println(pros.get(0).getId());
//        System.out.println(pros.get(0).getPrice());
//
//
//        System.out.println();
//        System.out.println("using the native query");
//
//        productProjection simply = productRepo.getTitleAndPriceFromProductId(52);
//        System.out.println(simply.getId());
//        System.out.println(simply.getTitle());
//        System.out.println(simply.getPrice());
//        System.out.println("done using the native query");
//
//        System.out.println("*******************************************");
//        System.out.println("Checking about the fetch types Lazy and Eager");
//
//        Category cat = categoryRepo.findByTitle("Luxury Sedans");
//        System.out.println(cat);
//        System.out.println(cat.getProducts());
//        System.out.println("*******************************************");

    }

}
