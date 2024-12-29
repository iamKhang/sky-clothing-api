package com.iamkhangg.skyclothingapi.converters;

import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import org.springframework.stereotype.Component;

@Component
public class ProductConverter {
    public ProductDTO convertToDTO(Product product, ProductVariant productVariant) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setProductId(product.getProductId());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setMaxDiscountPercentage(productVariant.getDiscountPercentage());
        productDTO.setPrice(product.getPrice());
        productDTO.setSubImageUrl(product.getSubImageUrl());
        productDTO.setMainImageUrl(product.getMainImageUrl());
        return productDTO;
    }
}
