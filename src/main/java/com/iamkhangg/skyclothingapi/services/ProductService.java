package com.iamkhangg.skyclothingapi.services;

import java.util.List;

import com.iamkhangg.skyclothingapi.entities.Product;


public interface ProductService {
    List<Product> getAllProducts(int page, int size);
    Product getProductById(String productId);
    Product createProduct(Product product);
    Product updateProduct(String productId, Product product);
    void deleteProduct(String productId);
}
