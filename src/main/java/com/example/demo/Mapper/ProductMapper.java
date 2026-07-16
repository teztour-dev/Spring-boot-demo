package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.DTO.ProductCreateRequestDTO;
import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.Model.Product;

@Component
public class ProductMapper {

     public ProductResponseDTO toResponseDTO(Product product){

        ProductResponseDTO dto = new ProductResponseDTO();

        dto.setId(product.getId());
        dto.setProductName(product.getName());
        dto.setProductPrice(product.getPrice());

        return dto;
    }

    public Product toEntity(ProductCreateRequestDTO dto){

    Product product = new Product();

    product.setName(dto.getName());
    product.setPrice(dto.getPrice());
    product.setQuantity(dto.getQuantity());

    return product;
}
}
