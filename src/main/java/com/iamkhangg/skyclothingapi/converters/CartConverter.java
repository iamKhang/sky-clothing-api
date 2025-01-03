package com.iamkhangg.skyclothingapi.converters;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.CartDTO;
import com.iamkhangg.skyclothingapi.dtos.CartItemDTO;
import com.iamkhangg.skyclothingapi.dtos.ProductVariantDTO;
import com.iamkhangg.skyclothingapi.entities.Cart;
import com.iamkhangg.skyclothingapi.entities.CartItem;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;

@Component
public class CartConverter {

    public CartDTO convertToDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setUserId(cart.getUser().getUserId());
        cartDTO.setCartItems(cart.getCartItems().stream()
                .map(this::convertCartItemToDTO)
                .collect(Collectors.toList()));
        return cartDTO;
    }

    private CartItemDTO convertCartItemToDTO(CartItem cartItem) {
        ProductVariant productVariant = cartItem.getProductVariant();
        ProductVariantDTO productVariantDTO = ProductVariantConverter.toDTO(productVariant);


        return new CartItemDTO(
                cartItem.getCartItemId(),
                productVariantDTO,
                cartItem.getQuantity()
        );
    }
}