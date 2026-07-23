package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductCreateRequestDTO {

    @NotBlank( message = "Product name is required")
    private String name;
    
    @NotNull( message = "Product price is required")
    @Positive( message = "Product price must be greater than zero")
    private Double price;

    @Positive( message = "The quantity must be greater than zero")
    @NotNull( message = "quantity is required")
    private Integer quantity;

    @NotNull( message = "Category ID is required")
    private Integer categoryId;


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public ProductCreateRequestDTO() {
    }


     public ProductCreateRequestDTO(String name, Double price, Integer quantity, Integer categoryId) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
