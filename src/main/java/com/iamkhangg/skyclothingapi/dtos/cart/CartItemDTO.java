package com.iamkhangg.skyclothingapi.dtos.cart;

import java.math.BigDecimal;

import com.iamkhangg.skyclothingapi.dtos.product.ProductVariantDTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartItemDTO {
    private String cartItemId;
    private ProductVariantDTO variant;
    private Integer quantity;
    private BigDecimal itemTotal;

    @Override
    public String toString() {
        return "CartItemDTO{" +
                "cartItemId='" + cartItemId + '\'' +
                ", variant=" + variant +
                ", quantity=" + quantity +
                ", itemTotal=" + itemTotal +
                '}';
    }
} 