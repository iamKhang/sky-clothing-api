package com.iamkhangg.skyclothingapi.dtos;

import java.math.BigDecimal;
import java.util.Set;

import com.iamkhangg.skyclothingapi.enums.Status;

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
    private Status status;
    private BigDecimal price;
    private String category;
    private String collectionId;
    private Set<ProductVariantDTO> variants;
}
