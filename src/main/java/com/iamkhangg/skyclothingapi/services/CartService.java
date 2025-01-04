package com.iamkhangg.skyclothingapi.services;

import com.iamkhangg.skyclothingapi.dtos.AddToCartRequest;
import com.iamkhangg.skyclothingapi.entities.Cart;

public interface CartService {
    Cart addToCart(String userId, AddToCartRequest request);
    Cart getCart(String userId);
}
