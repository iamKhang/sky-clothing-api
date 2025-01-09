package com.iamkhangg.skyclothingapi.dtos.product;

import java.util.Set;

import com.iamkhangg.skyclothingapi.dtos.base.BaseProductDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetailDTO extends BaseProductDTO {
    private String description;
    private String sizeChartUrl;
    private String category;
    private String collectionId;
    private Set<ProductVariantDTO> variants;
} 