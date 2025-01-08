package com.iamkhangg.skyclothingapi.services;

import com.iamkhangg.skyclothingapi.dtos.cart.AddToCartDTO;
import com.iamkhangg.skyclothingapi.entities.Cart;

public interface CartService {
    Cart addToCart(String userId, AddToCartDTO addToCartDTO);
    Cart getCart(String userId);
}
