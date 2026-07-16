package com.example.demo.Service;

import java.util.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.DTO.ProductUpdateRequestDTO;
import com.example.demo.Exception.ProductNotFoundException;
import com.example.demo.Model.ApiResponse;
import com.example.demo.Model.Product;
import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.DTO.ProductCreateRequestDTO;
import com.example.demo.DTO.ProductPatchRequestDTO;
import com.example.demo.Repository.ProductRepository;
import com.example.demo.Specification.ProductSpecification;
import com.example.demo.Mapper.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final IProductMapper iProductMapper;

    public ProductService(ProductRepository productRepository, IProductMapper iProductMapper) {
        this.productRepository = productRepository;
        this.iProductMapper = iProductMapper;
    }

    public ApiResponseDTO<ProductResponseDTO> addProduct(ProductCreateRequestDTO dto) {

        Product product = iProductMapper.toEntityCreate(dto);

        Product savedProduct = productRepository.save(product);
        ProductResponseDTO response = iProductMapper.toResponseDTO(savedProduct);

        return new ApiResponseDTO<>("Product added successfully", response);
    }

    public ApiResponseDTO< Page<ProductResponseDTO>> getProducts(Pageable pageable) {

        Page<ProductResponseDTO> productDTOs = productRepository.findAll(pageable).map(iProductMapper::toResponseDTO);
    
        return new ApiResponseDTO<>("Products retrieved successfully", productDTOs);
    }

    public ProductResponseDTO getProductsByID(Integer id) {

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product with id " + id + " not found"));
        return iProductMapper.toResponseDTO(product);
    }

    public List<ProductResponseDTO> nameSearch(String keyword) {

        return productRepository.findAll(ProductSpecification.hasName(keyword)).stream().map(iProductMapper::toResponseDTO).toList();

    }

    public long countProducts() {
        return productRepository.total();
    }

    public double avgPrice() {
        return productRepository.avgPrice();
    }

    public ApiResponse deleteProduct(Integer id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ApiResponse("Product deleted successfully", "success");
        } else
            return new ApiResponse("Product not found", "error");
    }

    public ApiResponseDTO<ProductResponseDTO> updateProduct(Integer id, ProductUpdateRequestDTO updatedProduct) {

        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product with id " + id + " not found"));

        product.setName(updatedProduct.getName());
        product.setPrice(updatedProduct.getPrice());

        productRepository.save(product);

        return new ApiResponseDTO<>("Product updated successfully", iProductMapper.toResponseDTO(product));
    }

    public ApiResponseDTO<ProductResponseDTO> partialUpdateProduct(
            Integer id,
            ProductPatchRequestDTO dto) {

        Product product = productRepository
                .findById(id)
                .orElseThrow(() -> new ProductNotFoundException(
                        "Product with id " + id + " not found"));

        if (dto.getName() != null) {
            product.setName(dto.getName());
        }

        if (dto.getPrice() != null) {
            product.setPrice(dto.getPrice());
        }

        if (dto.getQuantity() != null) {
            product.setQuantity(dto.getQuantity());
        }

        Product savedProduct = productRepository.save(product);

        return new ApiResponseDTO<>(
                "Product updated successfully",
                iProductMapper.toResponseDTO(savedProduct));
    }
}
