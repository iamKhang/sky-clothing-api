package com.iamkhangg.skyclothingapi.converters;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.product.ProductSizeDTO;
import com.iamkhangg.skyclothingapi.entities.ProductSize;
import com.iamkhangg.skyclothingapi.enums.Size;

@Component
public class ProductSizeConverter {
    
    public static ProductSizeDTO toDTO(ProductSize productSize) {
        return ProductSizeDTO.builder()
                .sizeId(productSize.getSizeId())
                .sku(productSize.getSku())
                .size(productSize.getSize().name())
                .quantity(productSize.getQuantity())
                .soldQuantity(productSize.getSoldQuantity())
                .discountPercentage(productSize.getDiscountPercentage())
                .active(productSize.getActive())
                .newProduct(productSize.getNewProduct())
                .bestSeller(productSize.getBestSeller())
                .build();
    }

    public static ProductSize toEntity(ProductSizeDTO dto) {
        ProductSize size = new ProductSize();
        size.setSizeId(dto.getSizeId());
        size.setSku(dto.getSku());
        size.setSize(Size.valueOf(dto.getSize()));
        size.setQuantity(dto.getQuantity());
        size.setSoldQuantity(dto.getSoldQuantity());
        size.setDiscountPercentage(dto.getDiscountPercentage());
        size.setActive(dto.getActive());
        size.setNewProduct(dto.getNewProduct());
        size.setBestSeller(dto.getBestSeller());
        return size;
    }
} 