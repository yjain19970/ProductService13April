package com.scaler.yash.productservice13april.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Category extends BaseModel {
    private String name;
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    private List<Product> products;
}

// install a plugin in intelIj : JPABuddy

/**
 * DEFAULT:
 * 1:m
 * m:1
 * m:m
 * <p>
 * FetchType: LAZY
 * <p>
 * <p>
 * 1:1
 * FetchType: EAGER
 */

