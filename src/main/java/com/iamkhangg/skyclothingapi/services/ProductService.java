package com.iamkhangg.skyclothingapi.services;

import org.springframework.data.domain.Page;

import com.iamkhangg.skyclothingapi.dtos.product.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.dtos.product.ProductListDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.enums.Category;

public interface ProductService {
    Product getProductById(String productId);
    Product createProduct(Product product);
    Product updateProduct(String productId, Product product);
    void deleteProduct(String productId);
    Page<ProductListDTO> getAllProductsDTO(int page, int size);
    ProductDetailDTO getProductDetailById(String productId);
    ProductDetailDTO createProductDetail(ProductDetailDTO productDetailDTO);
    Page<ProductListDTO> getProductsByCategory(Category category, int page, int size);
    Page<ProductListDTO> getProductsByMainCategory(String mainCategory, int page, int size);
}
