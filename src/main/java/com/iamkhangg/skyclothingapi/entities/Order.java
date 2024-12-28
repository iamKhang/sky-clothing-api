package com.iamkhangg.skyclothingapi.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @UuidGenerator
    @Column(name = "order_id")
    private String orderId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "discount_id")
    private DiscountCode discountCode;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private String shippingAddress;

    @Column(nullable = false)
    private LocalDateTime orderDate;

    @Column(nullable = false, name = "total_amount")
    private BigDecimal totalAmount;

    @Column(nullable = false, name = "shipping_fee")
    private BigDecimal shippingFee;

    @Column(name = "is_completed", nullable = false)
    private boolean isCompleted;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", user=" + user +
                ", discountCode=" + discountCode +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", orderDate=" + orderDate +
                ", shippingAddress='" + shippingAddress + '\'' +
                ", totalAmount=" + totalAmount +
                ", shippingFee=" + shippingFee +
                ", isCompleted=" + isCompleted +
                '}';
    }
}