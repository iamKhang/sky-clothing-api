package com.iamkhangg.skyclothingapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private String cartItemId;
    private ProductVariantDTO productVariant;
    private Integer quantity;
}