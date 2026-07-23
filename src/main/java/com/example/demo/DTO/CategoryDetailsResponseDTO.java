package com.example.demo.DTO;

import java.util.List;

public class CategoryDetailsResponseDTO {

     private Integer id;
    private String categoryName;
    private List<ProductSummaryDTO> products;

    public CategoryDetailsResponseDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public List<ProductSummaryDTO> getProducts() {
        return products;
    }

    public void setProducts(List<ProductSummaryDTO> products) {
        this.products = products;
    }

    

}
