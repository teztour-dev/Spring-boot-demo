package com.example.demo.DTO;

import jakarta.validation.constraints.NotBlank;

public class CategoryCreateRequestDTO {

    @NotBlank(message = "Category name is required")
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
