package com.example.demo.Service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.DTO.CategoryCreateRequestDTO;
import com.example.demo.DTO.CategoryDetailsResponseDTO;
import com.example.demo.DTO.CategoryResponseDTO;
import com.example.demo.Exception.CategoryAlreadyExistsException;
import com.example.demo.Exception.CategoryNotFoundException;
import com.example.demo.Mapper.CategoryMapper;
import com.example.demo.Model.Category;
import com.example.demo.Repository.CategoryRepository;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryService(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    public ApiResponseDTO<CategoryResponseDTO> addCategory(CategoryCreateRequestDTO dto) {
        Category category = categoryMapper.toEntity(dto);

        if (categoryRepository.existsByName(category.getName())) {
            throw new CategoryAlreadyExistsException("Category with name '" + category.getName() + "' already exists.");
        }
        Category savedCategory = categoryRepository.save(category);
        CategoryResponseDTO response = categoryMapper.toResponseDTO(savedCategory);

        return new ApiResponseDTO<>("Category added successfully", response);
    }

    public ApiResponseDTO<Page<CategoryResponseDTO>> getAllCategories(Pageable pageable) {
        Page<CategoryResponseDTO> categoryDTOs = categoryRepository.findAll(pageable)
                .map(categoryMapper::toResponseDTO);

        return new ApiResponseDTO<>("Categories retrieved successfully", categoryDTOs);

    }

    public ApiResponseDTO<CategoryResponseDTO> getCategoryByName(String keyword) {
        Category category = categoryRepository.nameFilter(keyword)
                .orElseThrow(() -> new CategoryNotFoundException("Category with name '" + keyword + "' not found."));
        CategoryResponseDTO response = categoryMapper.toResponseDTO(category);
        return new ApiResponseDTO<>("Category retrieved successfully", response);
    }

    public ApiResponseDTO<CategoryDetailsResponseDTO> getCategoryById(Integer id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new CategoryNotFoundException("Category with id '" + id + "' not found."));
        CategoryDetailsResponseDTO response = categoryMapper.toDetailsDTO(category);
        return new ApiResponseDTO<>("Category retrieved successfully", response);
    }

}
