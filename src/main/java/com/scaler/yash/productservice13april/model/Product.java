package com.scaler.yash.productservice13april.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class Product extends BaseModel { // exactly a table a in your DB
    private String title;
    private String description;
    private String price;
    private String imageURL;

    @ManyToOne
    private Category category;


    // private: called access_modifier
}


