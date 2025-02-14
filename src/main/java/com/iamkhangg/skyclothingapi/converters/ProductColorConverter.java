package com.iamkhangg.skyclothingapi.converters;

import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.product.ProductColorDTO;
import com.iamkhangg.skyclothingapi.entities.ProductColor;
import com.iamkhangg.skyclothingapi.entities.ProductSize;
import com.iamkhangg.skyclothingapi.enums.Color;

@Component
public class ProductColorConverter {
    
    public static ProductColorDTO toDTO(ProductColor productColor) {
        return ProductColorDTO.builder()
                .colorId(productColor.getColorId())
                .color(productColor.getColor().name())
                .productImages(productColor.getProductImages().stream().toList())
                .sizes(productColor.getSizes().stream()
                        .map(ProductSizeConverter::toDTO)
                        .collect(Collectors.toSet()))
                .build();
    }

    public static ProductColor toEntity(ProductColorDTO dto) {
        ProductColor color = new ProductColor();
        color.setColorId(dto.getColorId());
        color.setColor(Color.valueOf(dto.getColor()));
        color.setProductImages(dto.getProductImages().stream().collect(Collectors.toCollection(TreeSet::new)));
        if (dto.getSizes() != null) {
            dto.getSizes().forEach(sizeDTO -> {
                ProductSize size = ProductSizeConverter.toEntity(sizeDTO);
                color.addSize(size);
            });
        }
        return color;
    }
} 