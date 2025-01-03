package com.iamkhangg.skyclothingapi.services.impl;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.dtos.AddToCartRequest;
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
    public Cart addToCart(String userId, AddToCartRequest request) {
        User user = (User) userRepository.findByEmail(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Cart cart = (Cart) cartRepository.findByEmail(userId)
                .orElse(new Cart());
        cart.setUser(user);

        ProductVariant productVariant = productVariantRepository.findById(request.getProductVariantId())
                .orElseThrow(() -> new RuntimeException("Product variant not found"));

        if (cart.getCartItems() == null) {
            cart.setCartItems(new ArrayList<>());
        }

        Optional<CartItem> existingCartItem = cart.getCartItems().stream()
                .filter(item -> item.getProductVariant().getVariantId().equals(request.getProductVariantId()))
                .findFirst();

        if (existingCartItem.isPresent()) {
            CartItem cartItem = existingCartItem.get();
            cartItem.setQuantity(cartItem.getQuantity() + request.getQuantity());
        } else {
            CartItem cartItem = new CartItem();
            cartItem.setProductVariant(productVariant);
            cartItem.setQuantity(request.getQuantity());
            cartItem.setCart(cart);
            cart.getCartItems().add(cartItem);
        }

        return cartRepository.save(cart);
    }
}
