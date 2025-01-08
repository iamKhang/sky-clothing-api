package com.iamkhangg.skyclothingapi.dtos.base;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseVariantDTO {
    private String variantId;
    private String sku;
    private String color;
    private String size;
    private Integer quantity;
    private BigDecimal discountPercentage;
    private Set<String> productImages;
} 