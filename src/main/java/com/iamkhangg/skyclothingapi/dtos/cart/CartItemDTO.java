package com.iamkhangg.skyclothingapi.dtos.cart;

import com.iamkhangg.skyclothingapi.dtos.product.ProductVariantDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private String cartItemId;
    private ProductVariantDTO variant;
    private Integer quantity;
    private BigDecimal itemTotal;
} 