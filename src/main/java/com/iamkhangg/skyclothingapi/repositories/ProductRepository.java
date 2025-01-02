package com.iamkhangg.skyclothingapi.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.enums.Category;

public interface ProductRepository extends JpaRepository<Product, String> {
    Page<Product> findByCategory(Category category, Pageable pageable);
}
