package com.example.demo.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.demo.DTO.CategoryCreateRequestDTO;
import com.example.demo.DTO.CategoryDetailsResponseDTO;
import com.example.demo.DTO.CategoryResponseDTO;
import com.example.demo.DTO.ProductSummaryDTO;
import com.example.demo.Model.Category;
import com.example.demo.Model.Product;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    @Mapping(source = "name", target = "categoryName")
    CategoryResponseDTO toResponseDTO(Category category);

    Category toEntity(CategoryCreateRequestDTO dto);

    @Mapping(source = "name", target = "productName")
    ProductSummaryDTO toProductSummaryDTO(Product product);

    @Mapping(source = "name", target = "categoryName")
    CategoryDetailsResponseDTO toDetailsDTO(Category category);


}
