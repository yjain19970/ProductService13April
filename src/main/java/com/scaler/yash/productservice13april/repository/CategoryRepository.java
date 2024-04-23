package com.scaler.yash.productservice13april.repository;

import com.scaler.yash.productservice13april.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByName(String name);
}
