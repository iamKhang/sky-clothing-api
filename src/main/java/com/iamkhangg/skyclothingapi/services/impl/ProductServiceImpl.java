package com.iamkhangg.skyclothingapi.services.impl;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.repositories.ProductRepository;
import com.iamkhangg.skyclothingapi.services.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;


    @Override
    public List<Product> getAllProducts(int page, int size) {
        return productRepository.findAll(PageRequest.of(page - 1, size)).getContent();
    }

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
}
