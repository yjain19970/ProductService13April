package com.scaler.yash.productservice13april.service;

import com.scaler.yash.productservice13april.dto.CreateProductRequestDTO;
import com.scaler.yash.productservice13april.exception.CategoryNotFoundException;
import com.scaler.yash.productservice13april.model.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {
    Product getProductById(Integer id);

    List<Product> getAllProducts(); // not paginated. This will return you all the products.

    Product createProduct(String title, String description,
                          String image, Double price, String category) throws CategoryNotFoundException;


    Page<Product> getPaginatedProduct(Integer pageSize, Integer pageNo); // paginated get products.

}
