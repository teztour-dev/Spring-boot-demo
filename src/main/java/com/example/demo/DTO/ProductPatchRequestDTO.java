package com.example.demo.DTO;

import jakarta.validation.constraints.Positive;

public class ProductPatchRequestDTO {
  
   
    private String name;

    @Positive( message = "Product price must be greater than zero")
    private Double price;

    @Positive( message = "The quantity must be greater than zero")
    private Integer quantity;


     public ProductPatchRequestDTO() {
    }
    

     public ProductPatchRequestDTO(String name,
            @Positive(message = "Product price must be greater than zero") Double price,
            @Positive(message = "The quantity must be greater than zero") Integer quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

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

}
