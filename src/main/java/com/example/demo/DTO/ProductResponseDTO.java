package com.example.demo.DTO;

public class ProductResponseDTO {

    private Integer id;
    private String productName;
    private Double productPrice;
    private Double productQuantity;

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public Double getProductPrice() {
        return productPrice;
    }
    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }
    public Double getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(Double productQuantity) {
        this.productQuantity = productQuantity;
    }


}
