package com.iamkhangg.skyclothingapi.converters;

import com.iamkhangg.skyclothingapi.dtos.ProductVariantDTO;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;

public class ProductVariantConverter {

    public static ProductVariantDTO toDTO(ProductVariant productVariant) {
        return new ProductVariantDTO(
            productVariant.getVariantId(),
            productVariant.getSku(),
            productVariant.getColor().name(),
            productVariant.getSize().name(),
            productVariant.getQuantity(),
            productVariant.getDiscountPercentage(),
            productVariant.getProductImages()
        );
    }

    public static ProductVariant toEntity(ProductVariantDTO productVariantDTO) {
        return new ProductVariant(
            productVariantDTO.getVariantId(),
            null, // Assuming product is not available in ProductVariantDTO
            productVariantDTO.getSku(),
            Color.valueOf(productVariantDTO.getColor()),
            Size.valueOf(productVariantDTO.getSize()),
            productVariantDTO.getQuantity(),
            null, // Assuming soldQuantity is not available in ProductVariantDTO
            productVariantDTO.getDiscountPercentage(),
            null, // Assuming createdDate is not available in ProductVariantDTO
            null, // Assuming active is not available in ProductVariantDTO
            null, // Assuming newProduct is not available in ProductVariantDTO
            null, // Assuming bestSeller is not available in ProductVariantDTO
            productVariantDTO.getProductImages()
        );
    }
}
