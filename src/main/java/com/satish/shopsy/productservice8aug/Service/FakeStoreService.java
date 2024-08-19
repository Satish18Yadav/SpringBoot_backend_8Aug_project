package com.satish.shopsy.productservice8aug.Service;
import com.satish.shopsy.productservice8aug.builder.ProductMapper;
import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

// by this we are telling the spring that this class is a special class
@Service
public class FakeStoreService implements ProductService {


    //RestTemplate is  a library that is used to call another server to get its response

    private RestTemplate restTemplate;
    private ProductMapper mapper;

    public FakeStoreService(RestTemplate restTemplate,ProductMapper mapper) {
        this.restTemplate = restTemplate;
        this.mapper=mapper;
    }



    /* 1. call the fakestore and return the response of the fakestore*/
    // 2. we will try to return a MODEL from here not DTO
    // 3. before returning the model we have to convert the response of the fakestore
    // 4. through DTO class as per our requirement into model. We do this using a Dto mapper class


    @Override
    public Product getProductById(Long id){

        System.out.println("I am inside the FakeStoreService and calling the Fakestore DB");

        //  first: call the API and then the response is converted into a DTO object
         ResponseEntity<FakeStoreProductDTO> response= restTemplate.
                             getForEntity(
                        "https://fakestoreapi.com/products/" + id,
                             FakeStoreProductDTO.class);


         if(response==null || response.getBody()==null){
           return null;
         }

        // here the response body is provided by the getBody() method,
        // which gives a plain text/html content

        FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        // assert dto != null;

        //finally we are returning model from the service

         return mapper.mapToProduct(fakeStoreProductDTO);
    }







    @Override
    public Product createProduct(String title,String price, String category,String description,
                             String image) {
            System.out.println("okay yes here we are , ready to create");
        //1. call the fakestore api
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setPrice(String.valueOf(price));
        requestBody.setCategory(category);
        requestBody.setDescription(description);



        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",
                                        requestBody,
                                        FakeStoreProductDTO.class);

        Product product =mapper.mapToProduct(response);

        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<>();
       ResponseEntity<FakeStoreProductDTO[]> responseEntity =restTemplate.getForEntity

               ("https://fakestoreapi.com/products",FakeStoreProductDTO[].class);

       FakeStoreProductDTO[] dtos = responseEntity.getBody();
       if(dtos==null || dtos.length==0){
           System.out.println("Something went wrong...No response from the server");
           new ArrayList<>();
       }
        for(int i=0;i<dtos.length;i++){
            products.add(mapper.mapToProduct(dtos[i]));
        }
       return products ;
    }
}
