package com.iamkhangg.skyclothingapi.controllers;

import com.iamkhangg.skyclothingapi.dtos.ProductDTO;
import com.iamkhangg.skyclothingapi.dtos.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.repositories.ProductRepository;
import com.iamkhangg.skyclothingapi.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    /**
     * Get list product by page and size
     */
    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int size) {
        return productService.getAllProducts(page, size);
    }
}
