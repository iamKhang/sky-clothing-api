package com.iamkhangg.skyclothingapi.dtos;

import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVariantDTO {
    private String variantId;
    private Product product;
    private String sku;
    private Color color;
    private Size size;
    private Integer quantity;
    private Integer soldQuantity;
    private BigDecimal discountPercentage;
    private LocalDate createdDate;
    private Boolean active;
    private Boolean newProduct;
    private Boolean bestSeller;
    private Set<String> productImages;
}
