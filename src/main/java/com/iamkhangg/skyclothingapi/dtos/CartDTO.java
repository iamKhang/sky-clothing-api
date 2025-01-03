package com.iamkhangg.skyclothingapi.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDTO {
    private String cartId;
    private String userId;
    private List<CartItemDTO> cartItems;
}