package com.iamkhangg.skyclothingapi.dtos.product;

import java.util.List;
import java.util.stream.Collectors;

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
    private String sizeChartUrl;
    private String category;
    private String collectionId;
    private List<ProductVariantDTO> variants;

    @Override
    public String toString() {
        return "ProductDetailDTO{" +
                "baseProduct=" + super.toString() +
                ", sizeChartUrl='" + sizeChartUrl + '\'' +
                ", category='" + category + '\'' +
                ", collectionId='" + collectionId + '\'' +
                ", variants=" + variants.stream().map(ProductVariantDTO::toString).collect(Collectors.joining(", ")) +
                '}';
    }
} 