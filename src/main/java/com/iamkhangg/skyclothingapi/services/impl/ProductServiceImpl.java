package com.iamkhangg.skyclothingapi.services.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.converters.ProductConverter;
import com.iamkhangg.skyclothingapi.converters.ProductDetailConverter;
import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.dtos.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Category;
import com.iamkhangg.skyclothingapi.repositories.ProductRepository;
import com.iamkhangg.skyclothingapi.services.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

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
    public Page<ProductDTO> getAllProductsDTO(int page, int size) {
        return productRepository.findAll(PageRequest.of(page - 1, size))
                .map(ProductConverter::toDTO);
    }

    @Override
    public ProductDetailDTO getProductDetailById(String productId) {
        Product product = productRepository.findById(productId).orElseThrow(() -> new RuntimeException("Product not found"));
        return ProductDetailConverter.toDTO(product);
    }

    @Override
    public ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO) {
        Product product = ProductDetailConverter.toEntity(productDetailDTO);
        if (product.getVariants() != null) {
            for (ProductVariant variant : product.getVariants()) {
                variant.setProduct(product);
            }
        }
        Product savedProduct = productRepository.save(product);

        return ProductDetailConverter.toDTO(savedProduct);
    }

    @Override
    public Page<ProductDTO> getProductsByCategory(Category category, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<Product> products = productRepository.findByCategory(category, pageRequest);
        return products.map(ProductConverter::toDTO);
    }
}
