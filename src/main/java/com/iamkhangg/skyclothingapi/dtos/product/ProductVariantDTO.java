package com.iamkhangg.skyclothingapi.dtos.product;

import com.iamkhangg.skyclothingapi.dtos.base.BaseVariantDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductVariantDTO extends BaseVariantDTO {
    private String productName;
} 