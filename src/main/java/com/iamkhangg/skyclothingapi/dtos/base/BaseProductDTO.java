package com.iamkhangg.skyclothingapi.dtos.base;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class BaseProductDTO {
    private String productId;
    private String name;
    private String mainImageUrl;
    private String subImageUrl;
    private BigDecimal price;
    private String status;

    @Override
    public String toString() {
        return "BaseProductDTO{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", mainImageUrl='" + mainImageUrl + '\'' +
                ", subImageUrl='" + subImageUrl + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                '}';
    }
} 