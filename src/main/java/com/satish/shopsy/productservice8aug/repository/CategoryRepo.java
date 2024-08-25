package com.satish.shopsy.productservice8aug.repository;

import com.satish.shopsy.productservice8aug.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepo extends JpaRepository<Category,Integer> {

    Category findByTitle(String title);
    List<Category> findAll();
}
