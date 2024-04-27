package com.scaler.yash.productservice13april.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Product extends BaseModel { // exactly a table a in your DB
    private String title;
    private String description;
    private String price;
    private String imageURL;

    @ManyToOne(cascade = {CascadeType.REMOVE})
    @JsonIgnore
    private Category category;
}


