package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class ProductUpdateRequestDTO {


    @NotBlank( message = "Product name is required")
    private String name;
    
    @NotNull( message = "Product price is required")
    @Positive( message = "Product price must be greater than zero")
    private Double price;

    @Positive( message = "The quantity must be greater than zero")
    @NotNull( message = "quantity is required")
    private Double quantity;

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

    public Double getQuantity() {
        return quantity;
    }

    public void setQuantity(Double quantity) {
        this.quantity = quantity;
    }

    public ProductUpdateRequestDTO(@NotBlank(message = "Product name is required") String name,
            @NotNull(message = "Product price is required") @Positive(message = "Product price must be greater than zero") Double price,
            @Positive(message = "The quantity must be greater than zero") @NotNull(message = "quantity is required") Double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public ProductUpdateRequestDTO() {
    }

    
}
