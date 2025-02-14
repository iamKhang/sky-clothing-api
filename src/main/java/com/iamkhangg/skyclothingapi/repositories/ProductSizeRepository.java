package com.iamkhangg.skyclothingapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamkhangg.skyclothingapi.entities.ProductSize;

@Repository
public interface ProductSizeRepository extends JpaRepository<ProductSize, String> {
    // Add custom queries if needed
} 