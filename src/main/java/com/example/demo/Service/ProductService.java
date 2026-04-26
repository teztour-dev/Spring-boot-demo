package com.example.demo.Service;

import java.util.*;

import org.springframework.stereotype.Service;

import com.example.demo.Model.ApiResponse;
import com.example.demo.Model.Product;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    /*
     * public ApiResponse getProducts(String name, Integer price) {
     * 
     * String message = "all Products fetched successfully";
     * if (name != null) {
     * message += " with name: " + name;
     * }
     * if (price != null) {
     * message += " and price: " + price;
     * }
     * return new ApiResponse(message, "success");
     * }
     * 
     * 
     * public ApiResponse getProductById(String id) {
     * return new ApiResponse("Product with ID " + id + " fetched successfully",
     * "success");
     * }
     * 
     * 
     * public ApiResponse addProduct (Product product) {
     * 
     * products.add(product);
     * 
     * String message = "Product : "
     * + product.getName() + " with price: "
     * + product.getPrice() + " added successfully";
     * 
     * return new ApiResponse(message, "success");
     * }
     * 
     * 
     * public ApiResponse updateProduct(int id, Product product) {
     * 
     * String message = "The price of Product with ID " + id + " and name: "
     * + product.getName() + "is updated successfully to: " + product.getPrice();
     * 
     * return new ApiResponse(message, "success");
     * }
     * 
     * 
     * public ApiResponse deleteProduct(int id) {
     * String message = "Product with ID " + id + " deleted successfully";
     * 
     * return new ApiResponse(message, "success");
     * 
     * }
     */

    public List<Product> getProducts(String name, Integer price) {

    List<Product> filteredProducts = new ArrayList<>();

    for (Product product : products) {

        boolean matches = true;

        if (name != null && !product.getName().equalsIgnoreCase(name)) {
            matches = false;
        }

        if (price != null && !product.getPrice().equals(price.doubleValue())) {
            matches = false;
        }

        if (matches) {
            filteredProducts.add(product);
        }
    }

    return filteredProducts;
}

    public Product getProductById(String id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null; // Return null if product not found
    }

    public ApiResponse addProduct(Product product) {
        products.add(product);
        return new ApiResponse("Product added successfully", "success");
    }

    public ApiResponse updateProduct(String id, Product updatedProduct) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                product.setName(updatedProduct.getName());
                product.setPrice(updatedProduct.getPrice());
                return new ApiResponse("Product updated successfully", "success");
            }
        }
        return new ApiResponse("Product not found", "error");

    }

    public ApiResponse deleteProduct(String id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId().equals(id)) {
                iterator.remove();
                return new ApiResponse("Product deleted successfully", "success");
            }
        }
        return new ApiResponse("Product not found", "error");

    }

}
