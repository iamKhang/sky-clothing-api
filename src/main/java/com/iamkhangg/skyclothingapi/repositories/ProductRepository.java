package com.iamkhangg.skyclothingapi.repositories;

import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;

public interface ProductRepository extends JpaRepository<Product, String> {

}
