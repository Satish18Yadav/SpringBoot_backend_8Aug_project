package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Category;

import java.util.Date;
import java.util.List;

public interface CategoryService {

    List<Category> getAllCategory();

    public Category getCategoryByTitle(String title);

    public Category createCategory(String title);
}
