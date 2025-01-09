package com.iamkhangg.skyclothingapi.converters;

import java.math.BigDecimal;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.dtos.cart.CartDTO;
import com.iamkhangg.skyclothingapi.dtos.cart.CartItemDTO;
import com.iamkhangg.skyclothingapi.dtos.product.ProductVariantDTO;
import com.iamkhangg.skyclothingapi.entities.Cart;
import com.iamkhangg.skyclothingapi.entities.CartItem;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;

@Component
public class CartConverter {
    public CartDTO convertToDTO(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setCartId(cart.getCartId());
        cartDTO.setUserId(cart.getUser().getUserId());
        cartDTO.setItems(cart.getCartItems().stream()
                .map(this::convertCartItemToDTO)
                .collect(Collectors.toList()));
        BigDecimal totalAmount = cart.getCartItems().stream()
                .map(cartItem -> cartItem.getProductVariant().getProduct().getPrice()
                        .multiply(BigDecimal.valueOf(cartItem.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
        cartDTO.setTotalAmount(totalAmount);
        return cartDTO;
    }

    private CartItemDTO convertCartItemToDTO(CartItem cartItem) {
        ProductVariant productVariant = cartItem.getProductVariant();
        ProductVariantDTO productVariantDTO = ProductVariantConverter.toDTO(productVariant);

        BigDecimal itemTotal = productVariant.getProduct().getPrice()
                .multiply(BigDecimal.valueOf(cartItem.getQuantity()));

        return new CartItemDTO(
                cartItem.getCartItemId(),
                productVariantDTO,
                cartItem.getQuantity(),
                itemTotal
        );
    }
}