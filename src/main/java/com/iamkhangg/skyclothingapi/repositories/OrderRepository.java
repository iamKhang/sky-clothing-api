package com.iamkhangg.skyclothingapi.repositories;

import com.iamkhangg.skyclothingapi.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, String> {
}
