package com.example.demo.Controller;

import java.util.List;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.ApiResponse;
import com.example.demo.Model.Product;
import com.example.demo.Model.Product.CreateGroup;
import com.example.demo.Model.Product.UpdateGroup;
import com.example.demo.Service.ProductService;

import jakarta.validation.Valid;

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

    /*
     * @GetMapping
     * public ApiResponse getProducts(
     * 
     * @RequestParam(required = false) String name,
     * 
     * @RequestParam(required = false) Integer price
     * )
     * {
     * return productService.getProducts(name, price);
     * }
     * 
     * @GetMapping("/{id}")
     * public ApiResponse getProductById(@PathVariable String id) {
     * return productService.getProductById(id);
     * }
     * 
     * @PostMapping
     * public ApiResponse addProduct(@RequestBody Product product) {
     * return productService.addProduct(product);
     * }
     * 
     * @PutMapping("/{id}")
     * public ApiResponse updateProduct(@PathVariable int id, @RequestBody Product
     * product) {
     * return productService.updateProduct(id, product);
     * }
     * 
     * 
     * @DeleteMapping("/{id}")
     * public ApiResponse deleteProduct(@PathVariable int id) {
     * return productService.deleteProduct(id);
     * }
     */

    //  -------------- validate --------------

    /*@GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer price) {
        return productService.getProducts(name, price);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }
 
    @PostMapping
    public ApiResponse addProduct(
       //  @Validated(CreateGroup.class)
         @RequestBody Product product) {
        return productService.addProduct(product);
    }

    @PutMapping("/{id}")
    public ApiResponse updateProduct(@PathVariable Integer id, 
        // @Validated(UpdateGroup.class)
         @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public ApiResponse deleteProduct(@PathVariable Integer id) {
        return productService.deleteProduct(id);
    }*/

 //     -------------- SQL repo --------------

     @PostMapping
    public ApiResponse addProduct(@Validated(CreateGroup.class) @RequestBody Product product) {
        return productService.addProduct(product);
    }
    

    @GetMapping
    public List<Product> getProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) Integer price) {
        return productService.getProducts(name, price);
    }

    @GetMapping("/search")
    public List<Product> filterProducts(@RequestParam String keyword) {
        return productService.nameSearch(keyword);
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
    public ApiResponse updateProduct(@PathVariable Integer id, @Validated(UpdateGroup.class) @RequestBody Product product) {
        
        return productService.updateProduct(id, product);
    }
}