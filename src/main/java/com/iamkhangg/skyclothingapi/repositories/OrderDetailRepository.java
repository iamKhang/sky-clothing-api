package com.iamkhangg.skyclothingapi.repositories;

import com.iamkhangg.skyclothingapi.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
}
