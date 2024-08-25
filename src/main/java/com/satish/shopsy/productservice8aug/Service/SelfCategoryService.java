package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("SelfCategoryService")
public class SelfCategoryService implements CategoryService{

    private CategoryRepo categoryrepo;

    public SelfCategoryService(CategoryRepo categoryrepo) {
        this.categoryrepo = categoryrepo;
    }

    public List<Category> getAllCategory() {
        List<Category> categories = categoryrepo.findAll();
        return categories;
    }

    public Category getCategoryByTitle(String title){
        Category category =categoryrepo.findByTitle(title);
        return category;
    }

    public Category createCategory(String category){
        Category category1 = new Category();
        category1.setTitle(category);
        category1.setCreatedAt(new Date());
        category1.setUpdatedAt(new Date());
        category1.setDeleted(false);
       Category existingCategory = categoryrepo.save(category1);

        System.out.println("Category is created and returned to the SelfProductService");
        return existingCategory;
    }

}
