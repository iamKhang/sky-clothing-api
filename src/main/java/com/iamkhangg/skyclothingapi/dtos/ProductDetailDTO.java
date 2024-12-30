package com.iamkhangg.skyclothingapi.dtos;

import java.math.BigDecimal;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailDTO {
    private String productId;
    private String name;
    private String description;
    private String mainImageUrl;
    private String subImageUrl;
    private String sizeChartUrl;
    private BigDecimal price;
    private String category;
    private Set<String> collections;
    private Set<ProductVariantDTO> variants;
}
