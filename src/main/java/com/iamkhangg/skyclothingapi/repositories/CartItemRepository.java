package com.iamkhangg.skyclothingapi.repositories;

import com.iamkhangg.skyclothingapi.entities.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, String> {
}
