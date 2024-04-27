package com.scaler.yash.productservice13april;

import com.scaler.yash.productservice13april.model.Category;
import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.repository.CategoryRepository;
import com.scaler.yash.productservice13april.repository.ProductRepository;
import com.scaler.yash.productservice13april.repository.projection.ProductWithTitleAndID;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ProductService13AprilApplicationTests {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private CategoryRepository catRepository;


    @Test
    void contextLoads() {
    }

    @Test
    void testMyDB() {
        List<Category> p = catRepository.findAll();
        System.out.println(" Cat is: " + p.size() + " " + p.get(0));

        List<Product> products = p.get(0).getProducts();
        System.out.println("title: " + products.get(0).getTitle());
    }

}
