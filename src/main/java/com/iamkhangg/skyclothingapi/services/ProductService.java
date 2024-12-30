package com.iamkhangg.skyclothingapi.services;

import java.util.List;

import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.dtos.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.entities.Product;


public interface ProductService {
    Product getProductById(String productId);
    Product createProduct(Product product);
    Product updateProduct(String productId, Product product);
    void deleteProduct(String productId);
    List<ProductDTO> getAllProductsDTO(int page, int size); // New method
    ProductDetailDTO getProductDetailById(String productId);
    ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO);
}
