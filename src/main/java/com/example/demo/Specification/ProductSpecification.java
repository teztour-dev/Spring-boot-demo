package com.example.demo.Specification;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.Model.Product;

public class ProductSpecification {

    public static Specification<Product> hasName(String name) {
        return (root, query, cb) -> cb.like(
                root.get("name"),
                "%" + name + "%");
    }

   
}
