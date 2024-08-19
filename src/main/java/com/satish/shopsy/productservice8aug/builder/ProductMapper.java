package com.satish.shopsy.productservice8aug.builder;

import com.satish.shopsy.productservice8aug.dto.FakeStoreProductDTO;
import com.satish.shopsy.productservice8aug.dto.ProductResponseDTO;
import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

    public  ProductResponseDTO convertToProductResponseDTO(Product product) {
        ProductResponseDTO dto= new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setDescription(product.getDescription());
        dto.setCategory(product.getCategory());
        dto.setTitle(product.getTitle());

        if(product.getId()==null){
            dto.setId(product.getId());
        }

        return dto;

    }


    //here in the mapper we are doing the mapping of the  dto => model, Product=model
    public Product mapToProduct (FakeStoreProductDTO dto){
        Product product= new Product();

        Category category = new Category();

        product.setTitle(dto.getTitle());
        product.setPrice(Double.valueOf(dto.getPrice()));

        category.setTitle(dto.getCategory());
        product.setCategory(category);

        product.setDescription(dto.getDescription());

        product.setId(dto.getId());
        product.setImageURL(dto.getImage());

        return product;
    }
}
