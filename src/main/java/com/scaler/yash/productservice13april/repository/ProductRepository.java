package com.scaler.yash.productservice13april.repository;

import com.scaler.yash.productservice13april.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product save(Product p);

    List<Product> findAll();

    Product findProductById(Integer id);

    Product findByDescription(String description);
}
