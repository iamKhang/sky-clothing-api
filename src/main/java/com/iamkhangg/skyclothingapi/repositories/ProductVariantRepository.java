package com.iamkhangg.skyclothingapi.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.iamkhangg.skyclothingapi.entities.ProductVariant;

@Repository
public interface ProductVariantRepository extends JpaRepository<ProductVariant, String> {
    // Ensure this method references the correct property in the Product entity
    List<ProductVariant> findTopByProduct_ProductIdOrderByDiscountPercentageDesc(String productId);
    /**
     * Find all product variants by product id
     */
    List<ProductVariant> findAllByProduct_ProductId(String productId);
}
