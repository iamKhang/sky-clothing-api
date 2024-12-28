package com.iamkhangg.skyclothingapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.List;

@Entity
@Table(name = "carts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cart {
    @Id
    @UuidGenerator
    @Column(name = "cart_id")
    private String cartId;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;


    @Override
    public String toString() {
        return "Cart{" +
                "cartId='" + cartId + '\'' +
                ", user=" + user +
                '}';
    }
}