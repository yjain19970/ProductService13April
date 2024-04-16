package com.scaler.yash.productservice13april.controller;

import com.scaler.yash.productservice13april.dto.CreateProductRequestDTO;
import com.scaler.yash.productservice13april.dto.ProductResponseDTO;
import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.service.ProductService;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public void getAllProducts() {
        // GET /products

    }

    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id) {
        Product product = productService.getProductById(id);
        // conversion from Product to DTO

        return convertProductToResponseDTO(product);
    }

    private ProductResponseDTO convertProductToResponseDTO(Product product) {
        ProductResponseDTO dto = new ProductResponseDTO();
        dto.setCategory(product.getCategory());
        dto.setId(product.getId());
        dto.setPrice(product.getPrice());
        dto.setImageURL(product.getImageURL());
        dto.setDescription(product.getDescription());
        dto.setTitle(product.getTitle());
        return dto;
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO dto) {
        Product p = productService.createProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice());

        return p;
    }
}
