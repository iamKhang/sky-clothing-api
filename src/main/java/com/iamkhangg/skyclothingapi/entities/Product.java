package com.iamkhangg.skyclothingapi.entities;

import java.math.BigDecimal;
import java.util.Set;

import org.hibernate.annotations.UuidGenerator;

import com.iamkhangg.skyclothingapi.enums.Category;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
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

    
    @OneToMany(mappedBy = "product")
    private Set<ProductVariant> variants;
    
    @ManyToMany(mappedBy = "products")
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
