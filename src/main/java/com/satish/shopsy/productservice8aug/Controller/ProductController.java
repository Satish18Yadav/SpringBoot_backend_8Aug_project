package com.satish.shopsy.productservice8aug.Controller;

import com.satish.shopsy.productservice8aug.Service.FakeStoreService;
import com.satish.shopsy.productservice8aug.Service.ProductService;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService svc;

    // injeting ProductService in ProductContoller
    //ProductService svc = new FakeStoreSevice();  and
    // ProductController bj = new ProductController(svc);
    public ProductController(ProductService svc) {
        this.svc=svc;
    }

    @PostMapping("/product")
    public void createProduct(){
    //call this method
    }

    @GetMapping("/products")
    public void getProductAllProducts(){

    }


    @GetMapping("/product/{id}")
    public void getProductByID(@PathVariable("id") Long id){

        if(id==null){
            //throw an exception
        }

        //calling to the service layer
        //pass the id of the product
        Product product = svc.getProductById(id);

        //we will do the conversion of model to DTO here
    }

    @DeleteMapping("product/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
    // pass the oid of the product which is to be deleted
    }
}
