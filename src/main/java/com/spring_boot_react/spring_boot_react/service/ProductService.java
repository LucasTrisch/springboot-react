package com.spring_boot_react.spring_boot_react.service;


import com.spring_boot_react.spring_boot_react.models.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {


    Product updateProduct(Product produto);

    void deleteProduct(Long id);

    List<Product> getAllProductos();

    List<Product> getAllProducts();

    Optional<Product> getProductById(Long id);

    Product saveProduto(Product produto);

    Product updateProduto(Product produto);

    Product saveProduct(Product product);
}