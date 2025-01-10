package com.iamkhangg.skyclothingapi.dtos.product;

import com.iamkhangg.skyclothingapi.dtos.base.BaseProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.Set;

@Data
@SuperBuilder
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class ProductListDTO extends BaseProductDTO {
    private BigDecimal maxDiscountPercentage;
    private Set<String> availableColors;
} 