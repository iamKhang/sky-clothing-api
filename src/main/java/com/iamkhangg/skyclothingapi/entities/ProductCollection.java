package com.iamkhangg.skyclothingapi.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.util.Set;

@Entity
@Table(name = "collections")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductCollection {
    @Id
    @UuidGenerator
    @Column(name = "collection_id")
    private String collectionId;

    @Column(nullable = false, name = "collection_name")
    private String collectionName;

    private String description;

    @ManyToMany
    @JoinTable(
            name = "product_collections",
            joinColumns = @JoinColumn(name = "collection_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private Set<Product> products;

    public ProductCollection(String collectionId) {
        this.collectionId = collectionId;
    }


    @Override
    public String toString() {
        return "ProductCollection{" +
                "collectionId='" + collectionId + '\'' +
                ", collectionName='" + collectionName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}