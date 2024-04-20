package com.scaler.yash.productservice13april.model;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Category extends BaseModel {
    private String name;
}
