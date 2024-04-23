package com.scaler.yash.productservice13april.service;

import com.scaler.yash.productservice13april.exception.CategoryNotFoundException;
import com.scaler.yash.productservice13april.model.Category;
import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.repository.CategoryRepository;
import com.scaler.yash.productservice13april.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("selfProductService")
public class SelfProductService implements ProductService {

    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    public SelfProductService(ProductRepository productRepository,
                              CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Product getProductById(Integer id) {
        // can you add some validations here?
        return productRepository.findProductById(id);
        // can append any extra information here.
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product createProduct(String title, String description, String image, Double price, String category) throws CategoryNotFoundException {
        // category_name
        Category fetchedCategory = categoryRepository.findByName(category);
        if (fetchedCategory == null) {
            throw new CategoryNotFoundException("category does not exist");
        }

        Product productToBeSaved = new Product();
        productToBeSaved.setTitle(title);
        productToBeSaved.setDescription(description);
        productToBeSaved.setImageURL(image);
        productToBeSaved.setPrice(String.valueOf(price));
        productToBeSaved.setCategory(fetchedCategory);


        Product updatedProduct = productRepository.save(productToBeSaved);
        return updatedProduct;
    }
}
