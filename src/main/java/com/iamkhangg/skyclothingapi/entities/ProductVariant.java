package com.iamkhangg.skyclothingapi.entities;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;
import java.util.SortedSet;
import java.util.concurrent.atomic.AtomicInteger;

import org.hibernate.annotations.UuidGenerator;

import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
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
@Table(name = "product_variants")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductVariant {
    private static final AtomicInteger sequence = new AtomicInteger(1000);

    @Id
    @UuidGenerator
    private String variantId;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(nullable = false, unique = true)
    private String sku;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Color color;

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


    @ElementCollection
    @CollectionTable(name = "product_images", joinColumns = @JoinColumn(name = "variant_id"))
    @Column(name = "image_url")
    private SortedSet<String> productImages;

    @PrePersist
    private void generateSku() {
        if (this.sku == null || this.sku.isEmpty()) {
            String prefix = generatePrefix();
            int sequenceNumber = sequence.getAndIncrement();
            this.sku = prefix + String.format("%04d", sequenceNumber);
        }
    }

    private String generatePrefix() {
        if (product != null && product.getName() != null) {
            String name = product.getName().toUpperCase();
            if (name.length() >= 3) {
                return name.substring(0, 3);
            } else {
                return (name + "XXX").substring(0, 3);
            }
        }
        return "XXX";
    }

    @Override
    public String toString() {
        return "ProductVariant{" +
                "variantId=" + variantId +
                ", product=" + product +
                ", sku='" + sku + '\'' +
                ", color=" + color +
                ", size=" + size +
                ", quantity=" + quantity +
                ", discountPercentage=" + discountPercentage +
                ", productImages=" + productImages +
                '}';
    }
}