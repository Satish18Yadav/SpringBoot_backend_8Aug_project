package com.satish.shopsy.productservice8aug.Service;


import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

// by this we are telling the spring that this class is a special class
@Service
public class FakeStoreService implements ProductService {


    //RestTemplate is  a library that is used to call another server to get its response

    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }



    /* 1. call the fakestore and return the response of the fakestore*/
    // 2. we will try to return a MODEL from here not DTO
    // 3. before returning the model we have to convert the response of the fakestore
    // 4. through DTO class as per our requirement into model. We do this using a Dto mapper class


    @Override
    public Product getProductById(Long id){

        System.out.println("I am inside the Productservice and calling the fakestore");

        //  first: call the API and then the response is converted into a DTO object
      ResponseEntity<FakeStoreProductDTO> response= restTemplate.
              getForEntity("https://fakestoreapi.com/products/" + id,
                      FakeStoreProductDTO.class);

      if(response.getBody()==null){
          // throw exception
          System.out.println("Product body is null");
      }

        // here the response body is provided by the getBody() method,
        // which gives a plain text/html content

      FakeStoreProductDTO fakeStoreProductDTO = response.getBody();

        // assert dto != null;
        //finally we are returning model from the service

        return maptoProduct(fakeStoreProductDTO);
    }


    //here in the service we are doing the mapping of the  dto => model, Product=model

    private Product maptoProduct(FakeStoreProductDTO dto) {
        Product product = new Product();
        Category category = new Category();
        category.setTitle(dto.getCategory().getTitle());// only for the category
        category.setId(dto.getCategory().getId());

        product.setCategory(category);// using the category here
        product.setTitle(dto.getTitle());
        product.setId(dto.getId());
        product.setDescription(dto.getDescription());
        product.setPrice(Double.parseDouble(dto.getPrice()));
        product.setImageURL(dto.getImages().get(0));

        return product;
    }

    @Override
    public Product createProduct(String title,String description,
                              String price,String category,String image) {

        //1. call the fakestore api
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();


        restTemplate.postForObject("",requestBody,FakeStoreProductDTO.class);

        return null;
    }
}
