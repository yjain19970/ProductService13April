package com.scaler.yash.productservice13april;

import com.scaler.yash.productservice13april.model.Product;
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


    @Test
    void contextLoads() {
    }

    @Test
    void testMyDB() {
        Product p = productRepository.getProductFromDBByTitleAndId(1, "soethign");
        System.out.println(" Product is: " + p);

        List<ProductWithTitleAndID> ppp = productRepository.findTitleAndIdOfAllProductsByPrice("109.21");
        System.out.println("ppp:  " + ppp);
        System.out.println("id: " + ppp.get(0).getId());
        System.out.println("desc: " + ppp.get(0).getDescription());
        System.out.println("title: " + ppp.get(0).getTitle());
    }

}
