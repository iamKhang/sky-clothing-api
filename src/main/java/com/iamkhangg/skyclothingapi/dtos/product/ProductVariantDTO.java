package com.iamkhangg.skyclothingapi.dtos.product;

import java.util.Set;

import com.iamkhangg.skyclothingapi.dtos.base.BaseVariantDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ProductVariantDTO extends BaseVariantDTO {
    private String productName;

    @Override
    public String toString() {
        return "ProductVariantDTO{" +
                "baseVariant=" + super.toString() +
                ", productName='" + productName + '\'' +
                '}';
    }
} 