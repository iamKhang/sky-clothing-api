package com.iamkhangg.skyclothingapi.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.services.ProductVariantService;
import com.iamkhangg.skyclothingapi.utils.SkuGenerator;

@Service
public class ProductVariantServiceImpl implements ProductVariantService {

    @Override
    public List<ProductVariant> getAllVariantsByProductId(String productId) {
        return List.of();
    }

    @Override
    public ProductVariant getVariantById(String variantId) {
        return null;
    }

    @Override
    public ProductVariant createVariant(String productId, ProductVariant variant) {
        List<ProductVariant> existingVariants = getAllVariantsByProductId(productId);

        String sku = SkuGenerator.generateSku(variant.getProduct().getName(), existingVariants, variant.getSize(), variant.getColor());
        variant.setSku(sku);
        return variant;
    }

    @Override
    public ProductVariant updateVariant(String variantId, ProductVariant variant) {
        return null;
    }

    @Override
    public void deleteVariant(String variantId) {

    }

    @Override
    public ProductVariant findVariantHaveDiscountPercentageHighest(String productId) {
        return null;
    }
}
