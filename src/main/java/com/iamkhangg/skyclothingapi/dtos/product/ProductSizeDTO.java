package com.iamkhangg.skyclothingapi.dtos.product;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class ProductSizeDTO {
    private String sizeId;
    private String sku;
    private String size;
    private Integer quantity;
    private Integer soldQuantity;
    private BigDecimal discountPercentage;
    private Boolean active;
    private Boolean newProduct;
    private Boolean bestSeller;
} 