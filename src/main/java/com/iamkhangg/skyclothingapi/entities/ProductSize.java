package com.iamkhangg.skyclothingapi.entities;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.hibernate.annotations.UuidGenerator;

import com.iamkhangg.skyclothingapi.enums.Size;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_sizes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSize {
    @Id
    @UuidGenerator
    private String sizeId;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private ProductColor productColor;

    @Column(nullable = false, unique = true)
    private String sku;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "sold_quantity")
    private Integer soldQuantity;

    @Column(name = "discount_percentage")
    private BigDecimal discountPercentage;

    @Column(name = "created_date")
    private LocalDate createdDate;

    private Boolean active;

    @Column(name = "new_product")
    private Boolean newProduct;

    @Column(name = "best_seller")
    private Boolean bestSeller;

    @PrePersist
    private void generateSku() {
        if (this.sku == null || this.sku.isEmpty() && productColor != null && productColor.getProduct() != null) {
            String name = productColor.getProduct().getName().toUpperCase();
            String prefix = name.length() >= 3 ? name.substring(0, 3) : (name + "XXX").substring(0, 3);
            String colorCode = productColor.getColor().name().substring(0, 2);
            String sizeCode = size.name().substring(0, 2);
            this.sku = String.format("%s-%s-%s-%04d", prefix, colorCode, sizeCode, System.currentTimeMillis() % 10000);
        }
    }
} 