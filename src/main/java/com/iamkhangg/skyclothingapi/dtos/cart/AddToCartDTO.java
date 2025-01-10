package com.iamkhangg.skyclothingapi.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AddToCartDTO {
    private String variantId;
    private Integer quantity;

    @Override
    public String toString() {
        return "AddToCartDTO{" +
                "variantId='" + variantId + '\'' +
                ", quantity=" + quantity +
                '}';
    }
} 