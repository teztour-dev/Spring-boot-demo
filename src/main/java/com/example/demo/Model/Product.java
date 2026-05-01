package com.example.demo.Model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Product {

    public interface CreateGroup {}
    public interface UpdateGroup {}


    @NotNull(groups = CreateGroup.class)
    @Positive(groups = CreateGroup.class)
    private Integer id;

    @NotBlank(groups = {CreateGroup.class, UpdateGroup.class})
    private String name;

    @NotNull(groups = {CreateGroup.class, UpdateGroup.class})
    @Positive(groups = {CreateGroup.class, UpdateGroup.class})
    private Double price;


    public Product(Integer id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

}
