package com.spring_boot_react.spring_boot_react.repository;

import com.spring_boot_react.spring_boot_react.models.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository {
    void deleteById(Long id);

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Long id);
}
