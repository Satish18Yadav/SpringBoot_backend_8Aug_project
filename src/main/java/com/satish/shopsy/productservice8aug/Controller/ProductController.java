package com.satish.shopsy.productservice8aug.Controller;

import com.satish.shopsy.productservice8aug.Service.FakeStoreService;
import com.satish.shopsy.productservice8aug.Service.ProductService;
import com.satish.shopsy.productservice8aug.builder.ProductMapper;
import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import com.satish.shopsy.productservice8aug.dto.ProductResponseDTO;
import com.satish.shopsy.productservice8aug.dto.createProductRequestDTO;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService svc;
    private ProductMapper mapper;
    private createProductRequestDTO dto;

    // injeting ProductService in ProductContoller
    //ProductService svc = new FakeStoreSevice();  and
    // ProductController bj = new ProductController(svc);

    public ProductController(ProductService svc,ProductMapper mapper) {
        this.svc=svc;
        this.mapper=mapper;
    }

    @PostMapping("/product")
    public ProductResponseDTO createProduct(@RequestBody createProductRequestDTO dto){


        //call this method
        // call the service layer
        Product productResp= svc.createProduct(dto.getTitle(),dto.getPrice(),dto.getCategory(),
                                dto.getDescription(), dto.getImage());



      //convert this to DTO and return

        return mapper.convertToProductResponseDTO(productResp);
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
        ProductResponseDTO response= mapper.convertToProductResponseDTO(product);

        return response;
    }

    private void valiDateRequestParam(Long id) {
        //validations
        if(id==null){
            //throw an exception
        }
    }

    //we will do the conversion of model to DTO here


    @DeleteMapping("product/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
    // pass the oid of the product which is to be deleted
    }
}
