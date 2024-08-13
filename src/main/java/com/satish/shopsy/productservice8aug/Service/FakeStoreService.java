package com.satish.shopsy.productservice8aug.Service;


import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.stereotype.Service;

// by this we are telling the spring that this class is a special class
@Service
public class FakeStoreService implements ProductService {

    @Override
    public Product getProductById(Long id){
        /*call the fakestore and return the response of the fakestore*/
        // we will try to return a MODEL from here not DTO
        // before returning the model we have to convert the response of the fakestore
        // through DTO class as per our requirement into model. We do this using a Dto mapper class

        return null;
    }

    @Override
    public void createProduct() {

    }
}
