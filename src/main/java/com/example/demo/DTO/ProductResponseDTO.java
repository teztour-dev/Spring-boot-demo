package com.example.demo.DTO;

public class ProductResponseDTO {

    private Integer id;
    private String productName;
    private Double productPrice;
    private Integer productQuantity;
    private String categoryName;
    private Integer categoryId;

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
    public Integer getProductQuantity() {
        return productQuantity;
    }
    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public String getCategoryName() {
        return categoryName;
    }
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {
        return categoryId;
    }
    
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}
