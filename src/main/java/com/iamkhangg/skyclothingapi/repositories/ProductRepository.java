package com.iamkhangg.skyclothingapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.enums.Category;

public interface ProductRepository extends JpaRepository<Product, String> {
    @Query("SELECT p FROM Product p WHERE p.category = :category AND p.status = 'AVAILABLE'")
    Page<Product> findByCategory(@Param("category") Category category, Pageable pageable);
    
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    Page<Product> findAllByCategory(@Param("category") Category category, Pageable pageable);
}
