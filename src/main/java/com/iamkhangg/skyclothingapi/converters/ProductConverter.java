package com.iamkhangg.skyclothingapi.converters;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;

@Component
public class ProductConverter {

    public static ProductDTO toDTO(Product product) {
        BigDecimal maxDiscountPercentage = product.getVariants().stream()
                .map(ProductVariant::getDiscountPercentage)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        return new ProductDTO(
            product.getProductId(),
            product.getName(),
            product.getMainImageUrl(),
            product.getSubImageUrl(),
            product.getStatus(),
            product.getPrice(),
            maxDiscountPercentage
        );
    }

    public static Product toEntity(ProductDTO productDTO) {
        Product product = new Product();
        product.setProductId(productDTO.getProductId());
        product.setName(productDTO.getName());
        product.setMainImageUrl(productDTO.getMainImageUrl());
        product.setSubImageUrl(productDTO.getSubImageUrl());
        product.setPrice(productDTO.getPrice());
        product.setStatus(productDTO.getStatus());
        return product;
    }
}
