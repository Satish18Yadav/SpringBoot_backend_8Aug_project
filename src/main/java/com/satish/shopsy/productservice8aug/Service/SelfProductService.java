package com.satish.shopsy.productservice8aug.Service;

import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import com.satish.shopsy.productservice8aug.repository.CategoryRepo;
import com.satish.shopsy.productservice8aug.repository.ProductRepo;
import com.satish.shopsy.productservice8aug.repository.projection.productProjection;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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


    //HQL query

   public Product getProductByIdAndTitle(Integer Id, String title){
      Product product= productrepo.getProductFromIdAndTitle(Id,title);

      productProjection productprojection = productrepo.getTitleAndPriceFromProductId(Id);

      return product;
   }

    public Page<Product> getPaginatedProducts(int page, int size) {
        // findAll(Pageable pageable);

        Page<Product> productPage = productrepo.findAll(PageRequest.of(page,size));
        // Page T
//        productPage.getTotalElements();
//        productPage.get();
//        productPage.getTotalPages();
//        List<Product> products =productPage.getContent();
        return productPage;
    }

    public Page<Product> getPageBySequence(int page, int size,String sortBy) {

       Page<Product> pageOfProduct = productrepo.findAll(PageRequest.of(page,size,
                                        Sort.Direction.ASC,sortBy));

       return pageOfProduct;
    }
}
