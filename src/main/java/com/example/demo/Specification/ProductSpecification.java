package com.example.demo.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Model.Product;

public class ProductSpecification {

    public static Specification<Product> hasName(String name) {
       
        if(name == null || name.isEmpty()) {
           return (root, query, cb) -> cb.conjunction();

        }
       
       
        return (root, query, cb) -> cb.like(
                root.get("name"),
                "%" + name + "%");
    }

    public static Specification<Product> greaterThanOrEqualToPrice(Double price) {

        if(price == null) {
            return (root, query, cb) -> cb.conjunction();
        }
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> lessThanOrEqualToPrice(Double price) {
        if(price == null) {
            return (root, query, cb) -> cb.conjunction(); 
        }
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("price"), price);
    }

    public static Specification<Product> greaterThanOrEqualToQuantity(Integer quantity) {
        if(quantity == null) {
            return (root, query, cb) -> cb.conjunction(); 
        }
        return (root, query, cb) -> cb.greaterThanOrEqualTo(root.get("quantity"), quantity);
    }

    public static Specification<Product> lessThanOrEqualToQuantity(Integer quantity) {
        if(quantity == null) {
            return (root, query, cb) -> cb.conjunction(); 
        }
        return (root, query, cb) -> cb.lessThanOrEqualTo(root.get("quantity"), quantity);
    }

}
