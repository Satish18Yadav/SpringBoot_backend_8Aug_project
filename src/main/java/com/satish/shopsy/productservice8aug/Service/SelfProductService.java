package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import com.satish.shopsy.productservice8aug.repository.CategoryRepo;
import com.satish.shopsy.productservice8aug.repository.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service("SelfProductService")
public class SelfProductService implements ProductService{

    private ProductRepo productrepo;
    private SelfCategoryService selfCategoryService;

    public SelfProductService(ProductRepo productrepo, SelfCategoryService selfCategoryService) {
        this.productrepo = productrepo;
        this.selfCategoryService = selfCategoryService;
    }

    public Product getProductById(Integer Id){
        Product prod = productrepo.findProductById(Id);
        return prod;
    }


    public Product createProduct(String title,
                                 String price,
                                 String categoryTitle,
                                 String description,
                                 String image){
        Product product = new Product();

        //creted the product model
        product.setTitle(title);
        product.setPrice(Double.valueOf(price));

        //created and called the category model
        product.setCategory(selfCategoryService.createCategory(categoryTitle));


        product.setDescription(description);
        product.setImageURL(image);
        product.setCreatedAt(new Date());
        product.setUpdatedAt(new Date());
        product.setDeleted(false);

        Product prodCreated = productrepo.save(product);
        return prodCreated;
    }

    public List<Product> getAllProducts(){
        List<Product> prods = productrepo.findAll();
        return prods;
    }
}
