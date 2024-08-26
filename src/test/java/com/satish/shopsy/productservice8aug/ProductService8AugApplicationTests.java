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

        List<productProjection> pros = productRepo.getIdAndPriceFromProductTitle("Mototrocatane");
        System.out.println(pros.get(0).getId());
        System.out.println(pros.get(0).getPrice());
    }

}
