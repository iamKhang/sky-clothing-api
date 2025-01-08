package com.iamkhangg.skyclothingapi.dtos.product;

import java.util.Set;

import com.iamkhangg.skyclothingapi.dtos.base.BaseProductDTO;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductDetailDTO extends BaseProductDTO {
    private String description;
    private String sizeChartUrl;
    private String category;
    private String collectionId;
    private Set<ProductVariantDTO> variants;
} 