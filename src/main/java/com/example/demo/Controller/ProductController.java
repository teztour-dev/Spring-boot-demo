package com.example.demo.Controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.DTO.ApiResponseDTO;
import com.example.demo.DTO.ProductCreateRequestDTO;
import com.example.demo.DTO.ProductPatchRequestDTO;
import com.example.demo.DTO.ProductResponseDTO;
import com.example.demo.DTO.ProductSearchDTO;
import com.example.demo.DTO.ProductUpdateRequestDTO;
import com.example.demo.Model.ApiResponse;
import com.example.demo.Service.ProductService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ApiResponseDTO<ProductResponseDTO> addProduct(@Validated @RequestBody ProductCreateRequestDTO dto) {
        return productService.addProduct(dto);
    }

    @GetMapping
    public ApiResponseDTO<Page<ProductResponseDTO>> getProducts(Pageable pageable) {
        return productService.getProducts(pageable);
    }

    @GetMapping("/{id}")
    public ProductResponseDTO getById(@PathVariable Integer id) {
        return productService.getProductsByID(id);
    }

    @GetMapping("/search")
    public ApiResponseDTO<List<ProductResponseDTO>> searchProducts(
            ProductSearchDTO searchDTO) {

        return productService.search(searchDTO);

    }

    @GetMapping("/count")
    public long countProducts() {
        return productService.countProducts();
    }

    @GetMapping("/avg")
    public double avgProductPrices() {
        return productService.avgPrice();
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ApiResponseDTO<ProductResponseDTO> updateProduct(@PathVariable Integer id,
            @Validated @RequestBody ProductUpdateRequestDTO updatedProduct) {

        return productService.updateProduct(id, updatedProduct);
    }

    @PatchMapping("/{id}")
    public ApiResponseDTO<ProductResponseDTO> partialUpdateProduct(@PathVariable Integer id,
            @Validated @RequestBody ProductPatchRequestDTO updatedProduct) {
        return productService.partialUpdateProduct(id, updatedProduct);
    }
}