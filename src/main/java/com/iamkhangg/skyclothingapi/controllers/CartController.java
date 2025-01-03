package com.iamkhangg.skyclothingapi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamkhangg.skyclothingapi.converters.CartConverter;
import com.iamkhangg.skyclothingapi.dtos.AddToCartRequest;
import com.iamkhangg.skyclothingapi.dtos.CartDTO;
import com.iamkhangg.skyclothingapi.entities.Cart;
import com.iamkhangg.skyclothingapi.services.CartService;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private CartConverter cartConverter;

    @PostMapping("/add")
    public ResponseEntity<CartDTO> addToCart(@RequestBody AddToCartRequest request, Authentication authentication) {
        String userId = authentication.getName();
        Cart cart = cartService.addToCart(userId, request);
        CartDTO cartDTO = cartConverter.convertToDTO(cart);
        return ResponseEntity.ok(cartDTO);
    }
}
