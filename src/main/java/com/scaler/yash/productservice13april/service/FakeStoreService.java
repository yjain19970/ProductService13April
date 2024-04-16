package com.scaler.yash.productservice13april.service;

import com.scaler.yash.productservice13april.dto.FakeStoreProductDTO;
import com.scaler.yash.productservice13april.model.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreService implements ProductService {
    private RestTemplate restTemplate;

    public FakeStoreService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Product getProductById(Integer id) {
        ResponseEntity<FakeStoreProductDTO> response = restTemplate.getForEntity("https://fakestoreapi.com/products/" + id,
                FakeStoreProductDTO.class);
        FakeStoreProductDTO fakeStoreResponseDTO = response.getBody();
        return fakeStoreResponseDTO.toProduct();
    }

    @Override
    public Product getAllProducts() {
        System.out.println("djsdsok");
        return null;
    }

    @Override
    public Product createProduct(String title, String description, String image, Double price) {
        FakeStoreProductDTO requestBody = new FakeStoreProductDTO();
        requestBody.setTitle(title);
        requestBody.setDescription(description);
        requestBody.setImage(image);
        requestBody.setPrice(String.valueOf(price));

        FakeStoreProductDTO response = restTemplate.postForObject("https://fakestoreapi.com/products",
                requestBody, FakeStoreProductDTO.class);

        return response.toProduct();
    }
}
