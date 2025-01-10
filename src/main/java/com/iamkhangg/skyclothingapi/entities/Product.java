package com.iamkhangg.skyclothingapi.entities;

import java.math.BigDecimal;
import java.util.Set;
import java.util.HashSet;

import org.hibernate.annotations.UuidGenerator;

import com.iamkhangg.skyclothingapi.enums.Category;
import com.iamkhangg.skyclothingapi.enums.Status;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    
    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private Set<ProductVariant> variants;

    @ManyToOne
    @JoinColumn(name = "collection_id")
    private ProductCollection collection;

    public void addVariant(ProductVariant variant) {
        if (variants == null) {
            variants = new HashSet<>();
        }
        variants.add(variant);
        variant.setProduct(this);
    }

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
