package com.scaler.yash.productservice13april.service;

import com.scaler.yash.productservice13april.dto.ProductResponseDTO;
import com.scaler.yash.productservice13april.exception.CategoryNotFoundException;
import com.scaler.yash.productservice13april.model.Category;
import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.repository.CategoryRepository;
import com.scaler.yash.productservice13april.repository.ProductRepository;
import com.scaler.yash.productservice13april.repository.projection.ProductWithTitleAndID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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

        List<ProductWithTitleAndID> list = productRepository.findTitleAndIdOfAllProductsByPrice("109.21");
        convertToYourDTOFromProjection(list);
        return updatedProduct;
    }

    @Override
    public Page<Product> getPaginatedProduct(Integer pageSize, Integer pageNo) {
        Pageable pageable = PageRequest.of(pageSize, pageNo);
        Page<Product> product = productRepository.findAll(pageable);
        return product;
    }

    private void convertToYourDTOFromProjection(List<ProductWithTitleAndID> list) {
        ProductResponseDTO dto = new ProductResponseDTO();
        ProductWithTitleAndID pt = list.get(0);

        if (pt.getTitle() != null) {
            dto.setTitle(pt.getTitle());
        }
        if (pt.getId() != null) {
            dto.setId(pt.getId());
        }
    }
}
