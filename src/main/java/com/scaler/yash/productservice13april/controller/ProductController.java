package com.scaler.yash.productservice13april.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

    @GetMapping("/products")
    public void getAllProducts() {
        // GET /products

    }

    @GetMapping("/products/{id}")
    public void getProductById(@PathVariable("id") Integer id) {

    }

    @PostMapping("/products")
    public void createProduct() {
        // POST /products

    }
}
