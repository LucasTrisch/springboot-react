package com.example.spring_react.controller;

import com.example.spring_react.models.Product;
import com.example.spring_react.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<com.example.spring_react.models.Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public ResponseEntity<com.example.spring_react.models.Product> getProductById(@PathVariable Long id) {
        Optional<com.example.spring_react.models.Product> product = productService.getProductById(id);
        return product.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public com.example.spring_react.models.Product createProduct(@RequestBody com.example.spring_react.models.Product product) {
        return productService.saveProduct(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<com.example.spring_react.models.Product> updateProduct(@PathVariable Long id, @RequestBody Product productDetails) {
        Optional<com.example.spring_react.models.Product> productOptional = productService.getProductById(id);
        if (productOptional.isPresent()) {
            com.example.spring_react.models.Product product = productOptional.get();
            product.setName(productDetails.getName());
            product.setDescription(productDetails.getDescription());
            product.setPrice(productDetails.getPrice());
            return ResponseEntity.ok(productService.updateProduct(product));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        Optional<com.example.spring_react.models.Product> product = productService.getProductById(id);
        if (product.isPresent()) {
            productService.deleteProduct(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}