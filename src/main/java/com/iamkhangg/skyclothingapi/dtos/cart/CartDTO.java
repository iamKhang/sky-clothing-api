package com.iamkhangg.skyclothingapi.dtos.cart;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private String cartId;
    private String userId;
    private List<CartItemDTO> items;
    private BigDecimal totalAmount;
} 