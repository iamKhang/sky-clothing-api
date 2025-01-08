package com.iamkhangg.skyclothingapi.controllers;

import com.iamkhangg.skyclothingapi.dtos.cart.CartDTO;
import com.iamkhangg.skyclothingapi.dtos.cart.CartItemDTO;
import com.iamkhangg.skyclothingapi.dtos.cart.AddToCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iamkhangg.skyclothingapi.converters.CartConverter;
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
    public ResponseEntity<CartDTO> addToCart(@RequestBody AddToCartDTO request, Authentication authentication) {
        if (request == null || request.getVariantId() == null || request.getQuantity() == null) {
            throw new IllegalArgumentException("Thông tin sản phẩm không hợp lệ");
        }
        
        if (request.getQuantity() <= 0) {
            throw new IllegalArgumentException("Số lượng s�n phẩm phải lớn hơn 0");
        }

        String userId = authentication.getName();
        Cart cart = cartService.addToCart(userId, request);
        CartDTO cartDTO = cartConverter.convertToDTO(cart);
        return ResponseEntity.ok(cartDTO);
    }

    @GetMapping("/get")
    public ResponseEntity<CartDTO> getCart(Authentication authentication) {
        String userId = authentication.getName();
        Cart cart = cartService.getCart(userId);
        CartDTO cartDTO = cartConverter.convertToDTO(cart);
        return ResponseEntity.ok(cartDTO);
    }
}
