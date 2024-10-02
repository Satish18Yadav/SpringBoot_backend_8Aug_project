package com.satish.shopsy.productservice8aug.Controller;

import com.satish.shopsy.productservice8aug.Service.FakeStoreService;
import com.satish.shopsy.productservice8aug.Service.ProductService;
import com.satish.shopsy.productservice8aug.builder.ProductMapper;
import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import com.satish.shopsy.productservice8aug.dto.ProductResponseDTO;
import com.satish.shopsy.productservice8aug.dto.createProductRequestDTO;
import com.satish.shopsy.productservice8aug.dto.errorDTO;
import com.satish.shopsy.productservice8aug.exceptions.InvalidProductIdException;
import com.satish.shopsy.productservice8aug.exceptions.ProductNotFoundException;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    private ProductService svc;
    private ProductMapper mapper;
    private createProductRequestDTO dto;

    // injeting ProductService in ProductContoller
    //ProductService svc = new FakeStoreSevice();  and
    // ProductController bj = new ProductController(svc);

    public ProductController(@Qualifier("SelfProductService") ProductService svc, ProductMapper mapper) {
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
    public List<ProductResponseDTO> getProductAllProducts(){

        //System.out.println("getting the entire list of the products at FakeStoreAPI.com");

        System.out.println("getting the entire list of the products from my Database");
        List<ProductResponseDTO> productResponseDTOList = new ArrayList<>();

           List<Product> productList= svc.getAllProducts();
           if(productList==null || productList.isEmpty()){
               return null;
           }
           for(int i=0;i<productList.size();i++){
                productResponseDTOList.add(mapper.convertToProductResponseDTO(productList.get(i)));
           }
           return productResponseDTOList;
    }


    @GetMapping("/product/{id}")
    public  ProductResponseDTO getProductByID (@PathVariable("id") Integer id)
            throws InvalidProductIdException, ProductNotFoundException {

        if(id==null){
            throw  new InvalidProductIdException("Please enter a valid product ID");
        }

        //1.calling to the service layer
        //pass the id of the product
        Product product = svc.getProductById(id);
        if(product==null){
           throw new ProductNotFoundException();
        }
        //map to the responseDTO
        ProductResponseDTO response= mapper.convertToProductResponseDTO(product);

        return response;
    }

    @GetMapping("/product/{id}/{title}")
        public ProductResponseDTO getProductusingIdAndTitle(@PathVariable("id") Integer id,
                                                         @PathVariable("title") String title)
                                                            throws ProductNotFoundException {

         if(id==null){
            throw new ProductNotFoundException("Give the ID");
            }
         Product product = svc.getProductByIdAndTitle(id,title);

         return mapper.convertToProductResponseDTO(product);
        }
    //we will do the conversion of model to DTO here


    @DeleteMapping("product/{id}")
    public void deleteProductById(@PathVariable("id") Long id){
    // pass the oid of the product which is to be deleted
    }

    // Pagination and Sorting for the contents received from the database
        @GetMapping("pagination/{page}/{pagesize}")
    public ResponseEntity<Map<String, Object>> getPaginatedProduct(@PathVariable("page") Integer page,
                                               @PathVariable("pagesize") Integer pagesize ){

            Page<Product> productPage = svc.getPaginatedProducts(page, pagesize);
            List<Product> products = productPage.getContent();

            // Building the response with pagination details
            Map<String, Object> response = new HashMap<>();
            response.put("products", products);
            response.put("currentPage", productPage.getNumber());
            response.put("totalItems", productPage.getTotalElements());
            response.put("totalPages", productPage.getTotalPages());
            return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("pageBySequence/{page}/{pagesize},{sortBy}")

    public ResponseEntity<List<Product>> pageBySequence(@PathVariable("page") Integer page,
                                                        @PathVariable ("pagesize") Integer pagesize
                                                        ,@PathVariable("sortBy") String sortBy){

        Page<Product> response =  svc.getPageBySequence(page,pagesize,sortBy);

        return new ResponseEntity<>(response.getContent(), HttpStatus.OK);
    }
}
