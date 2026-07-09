package com.example.demo.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "products")
public class Product {

    public interface CreateGroup {}
    public interface UpdateGroup {}

    //NotNull(groups = CreateGroup.class)
    //@Positive(groups = CreateGroup.class)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank( message = "Product name is required", groups = {CreateGroup.class, UpdateGroup.class})
    @Column(nullable = false)
    private String name;

    @NotNull( message = "Product price is required", groups = {CreateGroup.class, UpdateGroup.class})
    @Positive( message = "Product price must be greater than zero", groups = {CreateGroup.class, UpdateGroup.class})
    @Column(nullable = false)
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
