package com.iamkhangg.skyclothingapi.dtos.product;

import java.util.List;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductColorDTO {
    private String colorId;
    private String color;
    private List<String> productImages;
    private Set<ProductSizeDTO> sizes;
} 