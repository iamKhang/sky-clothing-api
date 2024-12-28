package com.iamkhangg.skyclothingapi.entities;

import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "product_variants")
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariant {
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

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Size size;

    @Column(nullable = false)
    private Integer quantity;

    @Column(name = "sold_quantity")
    private Integer soldQuantity;

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
    private Set<String> productImages;

    @Override
    public String toString() {
        return "ProductVariant{" +
                "variantId=" + variantId +
                ", product=" + product +
                ", sku='" + sku + '\'' +
                ", color=" + color +
                ", price=" + price +
                ", size=" + size +
                ", quantity=" + quantity +
                ", discountPercentage=" + discountPercentage +
                ", productImages=" + productImages +
                '}';
    }
}