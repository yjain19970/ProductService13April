package com.scaler.yash.productservice13april.dto;

import com.scaler.yash.productservice13april.model.Category;
import com.scaler.yash.productservice13april.model.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Integer id;
    private String title;
    private String price;
    private String category;
    private String description;
    private String image;

    public Product toProduct() {
        Product p = new Product();
        p.setDescription(description);
        p.setPrice(price);
        p.setImageURL(image);
        p.setTitle(title);
        p.setId(id);

        Category c = new Category();
        c.setName(category);
        p.setCategory(c);
        return p;
    }
}
