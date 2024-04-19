package com.scaler.yash.productservice13april.service;

import com.scaler.yash.productservice13april.model.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer id);

    List<Product> getAllProducts();

    Product createProduct(String title, String description,
                          String image, Double price);

}
