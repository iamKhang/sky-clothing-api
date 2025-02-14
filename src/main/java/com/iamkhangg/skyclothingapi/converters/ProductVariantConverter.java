package com.iamkhangg.skyclothingapi.converters;

import com.iamkhangg.skyclothingapi.dtos.product.ProductVariantDTO;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;

import java.util.TreeSet;
import java.util.stream.Collectors;

public class ProductVariantConverter {

    public static ProductVariantDTO toDTO(ProductVariant productVariant) {
        return ProductVariantDTO.builder()
            .variantId(productVariant.getVariantId())
            .productName(productVariant.getProduct().getName())
            .sku(productVariant.getSku())
            .color(productVariant.getColor().name())
            .size(productVariant.getSize().name())
            .quantity(productVariant.getQuantity())
            .discountPercentage(productVariant.getDiscountPercentage())
            .productImages(productVariant.getProductImages().stream().toList())
            .build();
    }

    public static ProductVariant toEntity(ProductVariantDTO dto) {
        ProductVariant variant = new ProductVariant();
        variant.setVariantId(dto.getVariantId());
        variant.setSku(dto.getSku());
        variant.setColor(Color.valueOf(dto.getColor()));
        System.out.println("-------------------------------");
        System.out.println(dto.getSize());
        variant.setSize(Size.valueOf(dto.getSize()));
        variant.setQuantity(dto.getQuantity());
        variant.setDiscountPercentage(dto.getDiscountPercentage());
        TreeSet<String> images = new TreeSet<>();
        images.addAll(dto.getProductImages());
        variant.setProductImages(images);
        return variant;
    }
}
