package com.iamkhangg.skyclothingapi.dtos.product;

import com.iamkhangg.skyclothingapi.dtos.base.BaseProductDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
public class ProductListDTO extends BaseProductDTO {
    private BigDecimal maxDiscountPercentage;
    private Set<String> availableColors;
} 