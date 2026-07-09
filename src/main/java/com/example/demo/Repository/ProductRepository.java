package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

     List <Product> findByNameAndPrice(
        String name,
        Double price
);
    List<Product> findByName(String name);

   List<Product> findByPrice(Double price);

    // Return all products whose name contains a keyword
    @Query("select p from Product p where p.name like %:keyword%")
    List<Product> nameFilter(@Param("keyword") String keyword);

    // Return the total number of products
   @Query("select count(p) from Product p")
    Long total();

    // Return the average product price
    @Query("select avg(p.price) from Product p")
    Double avgPrice();

}

