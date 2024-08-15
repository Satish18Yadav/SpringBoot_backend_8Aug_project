package com.satish.shopsy.productservice8aug.Controller;

import com.satish.shopsy.productservice8aug.Service.FakeStoreService;
import com.satish.shopsy.productservice8aug.Service.ProductService;
import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import com.satish.shopsy.productservice8aug.dto.ProductResponseDTO;
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
    public ProductResponseDTO createProduct(@RequestBody FakeStoreProductDTO dto){
        //call this method
        // call the service layer



      //convert this to DTO and return


        return null;
    }

    @GetMapping("/products")
    public void getProductAllProducts(){
        // I will implement this today

    }


    @GetMapping("/product/{id}")
    public  ProductResponseDTO getProductByID(@PathVariable("id") Long id){

       valiDateRequestParam(id);

        //1.calling to the service layer
        //pass the id of the product
        Product product = svc.getProductById(id);

        //map to the responseDTO
        ProductResponseDTO response= convertToProductResponseDTO(product);

        return response;
    }

    private void valiDateRequestParam(Long id) {
        //validations
        if(id==null){
            //throw an exception
        }
    }

    //we will do the conversion of model to DTO here

    private ProductResponseDTO convertToProductResponseDTO(Product product){
        ProductResponseDTO dto= new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setDescription(product.getDescription());
        dto.setId(product.getId());
        dto.setTitle(product.getTitle());
        dto.setPrice(product.getPrice());

        if(product.getId()!=null){
            dto.setId(product.getId());
        }
        return dto;
    }
    @DeleteMapping("product/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
    // pass the oid of the product which is to be deleted
    }
}
