package com.iamkhangg.skyclothingapi.services;

import org.springframework.data.domain.Page;

import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.dtos.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.enums.Category;


public interface ProductService {
    Product getProductById(String productId);
    Product createProduct(Product product);
    Product updateProduct(String productId, Product product);
    void deleteProduct(String productId);
    Page<ProductDTO> getAllProductsDTO(int page, int size); // New method
    ProductDetailDTO getProductDetailById(String productId);
    ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO);
    Page<ProductDTO> getProductsByCategory(Category category, int page, int size);
}
