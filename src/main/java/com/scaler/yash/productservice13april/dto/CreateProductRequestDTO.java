package com.scaler.yash.productservice13april.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * {
 * *                     title: 'test product',
 * *                     price: 13.5,
 * *                     description: 'lorem ipsum set',
 * *                     image: 'https://i.pravatar.cc',
 * *                     category: 'electronic'
 * *                 }
 */
@Data
@NoArgsConstructor
public class CreateProductRequestDTO {
    Integer id;
    String title;
    Double price;
    String description;
    String image;
    String category;
}
