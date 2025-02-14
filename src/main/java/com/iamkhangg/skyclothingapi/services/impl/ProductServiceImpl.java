package com.iamkhangg.skyclothingapi.services.impl;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.converters.ProductConverter;
import com.iamkhangg.skyclothingapi.converters.ProductVariantConverter;
import com.iamkhangg.skyclothingapi.dtos.product.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.dtos.product.ProductListDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductCollection;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Category;
import com.iamkhangg.skyclothingapi.enums.Status;
import com.iamkhangg.skyclothingapi.repositories.ProductRepository;
import com.iamkhangg.skyclothingapi.repositories.ProductVariantRepository;
import com.iamkhangg.skyclothingapi.services.ProductService;
import com.iamkhangg.skyclothingapi.utils.SkuGenerator;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;

    @Override
    public Product getProductById(String productId) {
        return productRepository.findById(productId).orElse(null);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(String productId, Product product) {
        return productRepository.save(product);
    }

    @Override
    public void deleteProduct(String productId) {
        productRepository.deleteById(productId);
    }

    @Override
    public Page<ProductListDTO> getAllProductsDTO(int page, int size) {
        return productRepository.findAll(PageRequest.of(page, size))
                .map(ProductConverter::toListDTO);
    }

    @Override
    public ProductDetailDTO getProductDetailById(String productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductConverter.toDetailDTO(product);
    }

    @Override
    public ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO) {
        Product product = new Product();
        product.setName(productDetailDTO.getName());
        product.setMainImageUrl(productDetailDTO.getMainImageUrl());
        product.setSubImageUrl(productDetailDTO.getSubImageUrl());
        product.setSizeChartUrl(productDetailDTO.getSizeChartUrl());
        product.setPrice(productDetailDTO.getPrice());
        product.setStatus(Status.valueOf(productDetailDTO.getStatus()));
        product.setCategory(Category.valueOf(productDetailDTO.getCategory()));

        if (productDetailDTO.getCollectionId() != null) {
            product.setCollection(new ProductCollection(productDetailDTO.getCollectionId()));
        }

        if (productDetailDTO.getVariants() != null) {
            Set<ProductVariant> variants = productDetailDTO.getVariants().stream()
                    .map(ProductVariantConverter::toEntity)
                    .collect(Collectors.toSet());

            List<ProductVariant> allVariants = productVariantRepository.findAll();

            variants.forEach(variant -> {
                variant.setProduct(product);
                String sku = SkuGenerator.generateSku(product.getName(), allVariants, variant.getSize(), variant.getColor());
                variant.setSku(sku);
            });

            product.setVariants(variants);
        }

        Product savedProduct = productRepository.save(product);
        return ProductConverter.toDetailDTO(savedProduct);
    }

    @Override
    public Page<ProductListDTO> getProductsByCategory(Category category, int page, int size) {
        try {
            logger.debug("Searching products for category: {}, page: {}, size: {}", category, page, size);
            
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Product> products = productRepository.findByCategory(category, pageRequest);
            
            logger.debug("Found {} products", products.getTotalElements());
            
            if (products.isEmpty()) {
                logger.debug("No available products found, searching all products in category");
                products = productRepository.findAllByCategory(category, pageRequest);
                logger.debug("Found {} total products", products.getTotalElements());
            }
            
            return products.map(product -> {
                ProductListDTO dto = ProductConverter.toListDTO(product);
                logger.debug("Converted product: {}", dto);
                return dto;
            });
        } catch (Exception e) {
            logger.error("Error getting products by category: {}", e.getMessage(), e);
            throw new RuntimeException("Error getting products by category: " + e.getMessage());
        }
    }

    @Override
    public Page<ProductListDTO> getProductsByMainCategory(String mainCategory, int page, int size) {
        try {
            logger.debug("Searching products for main category: {}, page: {}, size: {}", mainCategory, page, size);
            
            PageRequest pageRequest = PageRequest.of(page, size);
            Page<Product> products = productRepository.findByMainCategory(mainCategory.toUpperCase(), pageRequest);
            
            logger.debug("Found {} products", products.getTotalElements());
            
            if (products.isEmpty()) {
                logger.debug("No available products found, searching all products in main category");
                products = productRepository.findAllByMainCategory(mainCategory.toUpperCase(), pageRequest);
                logger.debug("Found {} total products", products.getTotalElements());
            }
            
            return products.map(ProductConverter::toListDTO);
        } catch (Exception e) {
            logger.error("Error getting products by main category: {}", e.getMessage(), e);
            throw new RuntimeException("Error getting products by main category: " + e.getMessage());
        }
    }
}
