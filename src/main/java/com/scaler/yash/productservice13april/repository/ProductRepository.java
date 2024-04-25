package com.scaler.yash.productservice13april.repository;

import com.scaler.yash.productservice13april.model.Product;
import com.scaler.yash.productservice13april.repository.projection.ProductWithTitleAndID;
import jakarta.persistence.NamedNativeQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product save(Product p);

    List<Product> findAll();

    Product findProductById(Integer id);

    Product findByDescription(String description);

    // select * from products p where p.id=10;
    @Query("select p from Product p where p.id= :id and p.title= :title")
    Product getProductFromDBByTitleAndId(@Param("id") Integer id, @Param("title") String title);

    // another requirement: get all products (title,id)  by price (10.0)

    @Query("select p.title as title, p.id as id from Product p where p.price= :price")
    List<ProductWithTitleAndID> findTitleAndIdOfAllProductsByPrice(@Param("price") String price);

    /**
     * title1,id1
     * title2,id2
     * title3,id3
     * <p>
     * Projections
     * - they are interfaces
     * - methods here are `getters` for the attributes that are returned
     * from you query.
     * <p>
     * <p>
     * - getTitle()
     * - getId()
     */

    @Query(value = "select * from products where id=:id",
            nativeQuery = true)
    Product myOwnSQLForGettingProductFromDBById(Integer id);

}
