package com.scaler.yash.productservice13april.controller;

import com.scaler.yash.productservice13april.dto.CreateProductRequestDTO;
import com.scaler.yash.productservice13april.dto.ProductResponseDTO;
import com.scaler.yash.productservice13april.exception.CategoryNotFoundException;
import com.scaler.yash.productservice13april.exception.ProductNotFoundException;
import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.service.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductController {
    private ProductService productService;

    public ProductController(@Qualifier("selfProductService") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductResponseDTO> getAllProducts() {
        List<ProductResponseDTO> dtoList = new ArrayList<>();
        List<Product> products = productService.getAllProducts();

        for (Product p : products) {
            dtoList.add(convertProductToResponseDTO(p));
        }
        return dtoList;
    }

    @Cacheable(value = "product")
    @GetMapping("/products/{id}")
    public ProductResponseDTO getProductById(@PathVariable("id") Integer id) throws ProductNotFoundException {
        Product product = productService.getProductById(id);
        // conversion from Product to DTO
        if (product == null) {
            throw new ProductNotFoundException("some error occurred");
            //return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }

        ProductResponseDTO response = convertProductToResponseDTO(product);
        return response;
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

    @CachePut(value = "product", key = "#dto.title", unless = "#dto.title==null")
    // only insert the key in redis when title is present.
    // check: how we can save product model in redis cache using this technique.
    // as of now our DTO is actually getting saved in DB, what we want is:
    // model should be saved.

    // you will hav eto convert your MODEL to respective serializated object which is getting saved.
    @PostMapping("/products")
    public Product createProduct(@RequestBody CreateProductRequestDTO dto) throws CategoryNotFoundException {
        Product productResp = productService.createProduct(dto.getTitle(),
                dto.getDescription(),
                dto.getImage(),
                dto.getPrice(), dto.getCategory());

        return productResp;
    }

    @GetMapping("/products/{pageNo}/{pageSize}")
    public ResponseEntity<List<Product>> getPaginatedProduct(@PathVariable("pageNo") Integer pageNo,
                                                             @PathVariable("pageSize") Integer pageSize) {
        Page<Product> productPage = productService.getPaginatedProduct(pageSize, pageNo);
        System.out.println("ProductPage: " + productPage);
        return ResponseEntity.ok(productPage.getContent());
    }
}
