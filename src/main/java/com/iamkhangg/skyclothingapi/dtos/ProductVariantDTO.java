package com.iamkhangg.skyclothingapi.dtos;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductVariantDTO {
    private String variantId;
    private String productName;
    private String sku;
    private String color;
    private String size;
    private Integer quantity;
    private BigDecimal discountPercentage;
    private Set<String> productImages;
}