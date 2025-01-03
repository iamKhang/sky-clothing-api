package com.iamkhangg.skyclothingapi.dtos;

import java.math.BigDecimal;
import java.util.Set;

import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {
    private String productId;
    private String name;
    private String mainImageUrl;
    private String subImageUrl;
    private Status status;
    private BigDecimal price;
    private BigDecimal maxDiscountPercentage;
    private Set<Color> colors;
}
