package com.iamkhangg.skyclothingapi.dtos;

import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDetailDTO {
    private String productId;
    private String name;
    private String mainImageUrl;
    private String subImageUrl;
    private String sizeChartUrl;
    private String description;
    private List<ProductVariantDTO> variants;
}
