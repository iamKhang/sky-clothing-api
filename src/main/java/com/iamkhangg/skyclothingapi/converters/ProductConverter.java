package com.iamkhangg.skyclothingapi.converters;

import java.math.BigDecimal;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.product.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.dtos.product.ProductListDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;

@Component
public class ProductConverter {

    public static ProductListDTO toListDTO(Product product) {
        BigDecimal maxDiscount = product.getVariants().stream()
                .map(ProductVariant::getDiscountPercentage)
                .max(BigDecimal::compareTo)
                .orElse(BigDecimal.ZERO);

        Set<String> colors = product.getVariants().stream()
                .map(variant -> variant.getColor().name())
                .collect(Collectors.toSet());

        return ProductListDTO.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .mainImageUrl(product.getMainImageUrl())
                .subImageUrl(product.getSubImageUrl())
                .price(product.getPrice())
                .status(product.getStatus() != null ? product.getStatus().name() : null)
                .maxDiscountPercentage(maxDiscount)
                .availableColors(colors)
                .build();
    }

    public static ProductDetailDTO toDetailDTO(Product product) {
        return ProductDetailDTO.builder()
                .productId(product.getProductId())
                .name(product.getName())
                .description(product.getDescription())
                .mainImageUrl(product.getMainImageUrl())
                .subImageUrl(product.getSubImageUrl())
                .sizeChartUrl(product.getSizeChartUrl())
                .price(product.getPrice())
                .status(product.getStatus().name())
                .category(product.getCategory().name())
                .collectionId(product.getCollection() != null ? 
                    product.getCollection().getCollectionId() : null)
                .variants(product.getVariants().stream()
                    .map(ProductVariantConverter::toDTO)
                    .collect(Collectors.toSet()))
                .build();
    }
}
