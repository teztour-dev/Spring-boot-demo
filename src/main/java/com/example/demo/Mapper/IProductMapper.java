package com.example.demo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTO.ProductCreateRequestDTO;
import com.example.demo.DTO.ProductPatchRequestDTO;
import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.DTO.ProductUpdateRequestDTO;
import com.example.demo.Model.Product;

@Mapper(componentModel = "spring")
public interface IProductMapper {

    @Mapping(source = "name", target = "productName")
    @Mapping(source = "price", target = "productPrice")
    @Mapping(source = "quantity", target = "productQuantity")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "category.id", target = "categoryId")
    ProductResponseDTO toResponseDTO(Product product);


    Product toEntityCreate(ProductCreateRequestDTO dto);

    Product toEntityUpdate(ProductUpdateRequestDTO dto);

    Product toEntityPatch(ProductPatchRequestDTO dto);

}
