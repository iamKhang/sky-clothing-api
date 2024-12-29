package com.iamkhangg.skyclothingapi.services;

import java.util.List;

import com.iamkhangg.skyclothingapi.entities.ProductVariant;

public interface ProductVariantService {
    List<ProductVariant> getAllVariantsByProductId(String productId);
    ProductVariant getVariantById(String variantId);
    ProductVariant createVariant(String productId, ProductVariant variant);
    ProductVariant updateVariant(String variantId, ProductVariant variant);
    void deleteVariant(String variantId);
    ProductVariant findVariantHaveDiscountPercentageHighest(String productId);
}
