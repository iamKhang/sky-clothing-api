package com.iamkhangg.skyclothingapi.converters;

import java.util.stream.Collectors;

import com.iamkhangg.skyclothingapi.dtos.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductCollection;
import com.iamkhangg.skyclothingapi.enums.Category;

public class ProductDetailConverter {

    public static ProductDetailDTO toDTO(Product product) {
        return new ProductDetailDTO(
            product.getProductId(),
            product.getName(),
            product.getDescription(),
            product.getMainImageUrl(),
            product.getSubImageUrl(),
            product.getSizeChartUrl(),
            product.getPrice(),
            product.getCategory().name(),
            product.getCollections().stream().map(ProductCollection::getCollectionName).collect(Collectors.toSet()),
            product.getVariants().stream().map(ProductVariantConverter::toDTO).collect(Collectors.toSet())
        );
    }

    public static Product toEntity(ProductDetailDTO productDetailDTO) {
        Product product = new Product();
        product.setProductId(productDetailDTO.getProductId());
        product.setName(productDetailDTO.getName());
        product.setDescription(productDetailDTO.getDescription());
        product.setMainImageUrl(productDetailDTO.getMainImageUrl());
        product.setSubImageUrl(productDetailDTO.getSubImageUrl());
        product.setSizeChartUrl(productDetailDTO.getSizeChartUrl());
        product.setPrice(productDetailDTO.getPrice());
        product.setCategory(Category.valueOf(productDetailDTO.getCategory()));
        product.setCollections(productDetailDTO.getCollections().stream().map(name -> {
            ProductCollection collection = new ProductCollection();
            collection.setCollectionName(name);
            return collection;
        }).collect(Collectors.toSet()));
        product.setVariants(productDetailDTO.getVariants().stream().map(ProductVariantConverter::toEntity).collect(Collectors.toSet()));
        return product;
    }
}