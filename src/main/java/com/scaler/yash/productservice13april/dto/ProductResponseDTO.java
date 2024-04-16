package com.scaler.yash.productservice13april.dto;

import com.scaler.yash.productservice13april.model.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponseDTO {
    private Integer id;
    private String title;
    private String description;
    private String price;
    private String imageURL;
    private Category category;

}
