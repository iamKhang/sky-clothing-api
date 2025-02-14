package com.iamkhangg.skyclothingapi.controllers;

import com.iamkhangg.skyclothingapi.dtos.product.ProductVariantDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.iamkhangg.skyclothingapi.dtos.product.ProductDetailDTO;
import com.iamkhangg.skyclothingapi.dtos.product.ProductListDTO;
import com.iamkhangg.skyclothingapi.enums.Category;
import com.iamkhangg.skyclothingapi.services.ProductService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.lang.System.out;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public Page<ProductListDTO> getProducts(@RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return productService.getAllProductsDTO(page, size);
    }

    @GetMapping("/{productId}")
    public ResponseEntity<ProductDetailDTO> getProductDetail(@PathVariable String productId) {
        ProductDetailDTO productDetail = productService.getProductDetailById(productId);
        return ResponseEntity.ok(productDetail);
    }

    @PostMapping
    public ResponseEntity<ProductDetailDTO> createProductDetail(@RequestBody ProductDetailDTO productDetailDTO) {
        List<ProductVariantDTO> variants = productDetailDTO.getVariants();
        try {
            ProductDetailDTO createdProductDetail = productService.createProductDetail(productDetailDTO);
            return ResponseEntity.ok(createdProductDetail);
        } catch (Exception e) {
            // Log the error
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{mainCategory}")
    public ResponseEntity<Page<ProductListDTO>> getProductsByMainCategory(
            @PathVariable String mainCategory,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Page<ProductListDTO> products = productService.getProductsByMainCategory(mainCategory, page, size);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/category/{mainCategory}/{subCategory}")
    public ResponseEntity<Page<ProductListDTO>> getProductsByCategory(
            @PathVariable String mainCategory,
            @PathVariable String subCategory,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            Category category = Category.fromMainAndSubCategory(mainCategory, subCategory);
            Page<ProductListDTO> products = productService.getProductsByCategory(category, page, size);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

}