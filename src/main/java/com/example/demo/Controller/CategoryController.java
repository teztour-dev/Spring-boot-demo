package com.example.demo.Controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.DTO.CategoryCreateRequestDTO;
import com.example.demo.DTO.CategoryDetailsResponseDTO;
import com.example.demo.DTO.CategoryResponseDTO;
import com.example.demo.Service.CategoryService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping
    public ApiResponseDTO<CategoryResponseDTO> addCategory(@Validated @RequestBody CategoryCreateRequestDTO dto) {
        return categoryService.addCategory(dto);
    }

    @GetMapping
    public ApiResponseDTO<Page<CategoryResponseDTO>> getAllCategories(Pageable pageable) {
        return categoryService.getAllCategories(pageable);
    }

    @GetMapping("/search")
    public ApiResponseDTO<CategoryResponseDTO> getCategoryByName(@RequestParam String keyword) {
        return categoryService.getCategoryByName(keyword);
    }

    @GetMapping("/{id}")
    public ApiResponseDTO<CategoryDetailsResponseDTO> getCategoryById(@PathVariable Integer id) {
        return categoryService.getCategoryById(id);
    }
}
