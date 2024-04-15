package com.scaler.yash.productservice13april.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String imageURL;
    private Category category;



    // private: called access_modifier
}
