package com.iamkhangg.skyclothingapi.entities;

import java.math.BigDecimal;
import java.util.Set;

import jakarta.persistence.*;
import org.hibernate.annotations.UuidGenerator;

import com.iamkhangg.skyclothingapi.enums.Category;
import com.iamkhangg.skyclothingapi.enums.Status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
    @Id
    @UuidGenerator
    @Column(name = "product_id")
    private String productId;

    @Column(nullable = false)
    private String name;

    private String description;

    @Column(name = "main_image_url" ,nullable = false)
    private String mainImageUrl;

    @Column(name = "sub_image_url", nullable = false)
    private String subImageUrl;

    private String sizeChartUrl;

    @Column(nullable = false)
    private BigDecimal price;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;

    // tình trạng
    private Status status;

    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductVariant> variants;

    @ManyToMany(mappedBy = "products", cascade = CascadeType.PERSIST)
    private Set<ProductCollection> collections;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", mainImageUrl='" + mainImageUrl + '\'' +
                ", subImageUrl='" + subImageUrl + '\'' +
                ", sizeChartUrl='" + sizeChartUrl + '\'' +
                ", category=" + category +
                '}';
    }

    public Product(String productId) {
        this.productId = productId;
    }
}
