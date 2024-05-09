package com.scaler.yash.productservice13april;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProductService13AprilApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductService13AprilApplication.class, args);
    }
    /**
     * models == entities == resources
     *
     * product service
     *
     * * store details related to Product
     * * store details related to category
     *
     *
     *
     * Model:
     * Product
     *  - id
     *  - title
     *  - description
     *  - price
     *  - image_url
     *  - Category
     * Category
     *  - id
     *  - name
     *
     */
}
