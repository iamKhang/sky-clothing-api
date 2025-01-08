package com.iamkhangg.skyclothingapi.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import com.iamkhangg.skyclothingapi.dtos.cart.AddToCartDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.entities.Cart;
import com.iamkhangg.skyclothingapi.entities.CartItem;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.entities.User;
import com.iamkhangg.skyclothingapi.repositories.CartRepository;
import com.iamkhangg.skyclothingapi.repositories.ProductVariantRepository;
import com.iamkhangg.skyclothingapi.repositories.UserRepository;
import com.iamkhangg.skyclothingapi.services.CartService;

@Service
public class CartServiceImpl implements CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ProductVariantRepository productVariantRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Cart addToCart(String userId, AddToCartDTO addToCartDTO) {
        // Validate input
        if (addToCartDTO == null || addToCartDTO.getVariantId() == null || addToCartDTO.getQuantity() == null) {
            throw new IllegalArgumentException("Thông tin sản phẩm không hợp lệ");
        }

        User user = userRepository.findByEmail(userId)
                .orElseThrow(() -> new RuntimeException("Không tìm thấy người dùng"));

        Cart cart = cartRepository.findByEmail(userId)
                .orElse(new Cart());
        cart.setUser(user);

        ProductVariant productVariant = productVariantRepository.findById(addToCartDTO.getVariantId())
                .orElseThrow(() -> new RuntimeException("Không tìm thấy biến thể sản phẩm"));

        if (cart.getCartItems() == null) {
            cart.setCartItems(new ArrayList<>());
        }

        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProductVariant().getVariantId().equals(addToCartDTO.getVariantId()))
                .findFirst();

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + addToCartDTO.getQuantity());
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProductVariant(productVariant);
            cartItem.setQuantity(addToCartDTO.getQuantity());
            cartItem.setCart(cart);
            cart.getCartItems().add(cartItem);
        }

        return cartRepository.save(cart);
    }

    @Override
    public Cart getCart(String userId) {
        return cartRepository.findByEmail(userId)
                .orElseThrow(() -> new RuntimeException("Cart not found"));
    }
}
