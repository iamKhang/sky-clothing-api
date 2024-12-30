package com.iamkhangg.skyclothingapi.converters;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Color;

@Component
public class ProductConverter {

    public static ProductDTO toDTO(Product product) {
        BigDecimal maxDiscountPercentage = product.getVariants().stream()
                .map(ProductVariant::getDiscountPercentage)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        Set<Color> colors = product.getVariants().stream()
                .map(ProductVariant::getColor)
                .collect(Collectors.toSet());

        return new ProductDTO(
            product.getProductId(),
            product.getName(),
            product.getMainImageUrl(),
            product.getSubImageUrl(),
            product.getStatus(),
            product.getPrice(),
            maxDiscountPercentage,
            colors
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
