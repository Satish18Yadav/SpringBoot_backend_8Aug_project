package com.satish.shopsy.productservice8aug.repository;

import com.satish.shopsy.productservice8aug.model.Category;
import com.satish.shopsy.productservice8aug.model.Product;
import com.satish.shopsy.productservice8aug.repository.projection.productProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product,Integer> {

 List<Product> findAll();
//    List<Product> findByCategory(Category category);


 Product findProductById(Integer id);
 //Product findProductByDescription(String description);

 //create a Product
 Product save(Product p);

 //Let's write an HQL query
 @Query("select p from Product  p where p.Id= :Id and p.title= :title")
 Product getProductFromIdAndTitle(@Param("Id") Integer Id, @Param("title") String title);


 /*
 Get title and ID
 return something which is called as Projection
 */
// @Query("select p.Id,p.title,p.price from Product p where p.Id= :Id")
// productProjection getTitleAndPriceFromProductId(@Param("Id") Integer Id);

 // using the native query
 @Query(value = "SELECT Id, title, price FROM Product WHERE Id = :Id", nativeQuery = true)
 productProjection getTitleAndPriceFromProductId(@Param("Id") Integer Id);


 @Query("select p.id as id,p.price as price from Product p where p.title= ?1")
 List<productProjection> getIdAndPriceFromProductTitle( String title);
}