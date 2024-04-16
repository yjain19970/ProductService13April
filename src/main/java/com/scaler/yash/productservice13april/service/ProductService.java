package com.scaler.yash.productservice13april.service;

import com.scaler.yash.productservice13april.dto.CreateProductRequestDTO;
import com.scaler.yash.productservice13april.model.Product;

public interface ProductService {
    Product getProductById(Integer id);

    Product getAllProducts();

    Product createProduct(String title, String description,
                          String image, Double price);

}
