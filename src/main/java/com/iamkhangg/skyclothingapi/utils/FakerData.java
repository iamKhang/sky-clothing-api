package com.iamkhangg.skyclothingapi.utils;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.iamkhangg.skyclothingapi.entities.Product;
import com.iamkhangg.skyclothingapi.entities.ProductCollection;
import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Category;
import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;
import com.iamkhangg.skyclothingapi.repositories.ProductCollectionRepository;
import com.iamkhangg.skyclothingapi.repositories.ProductRepository;
import com.iamkhangg.skyclothingapi.repositories.ProductVariantRepository;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import net.datafaker.Faker;

@Component
@RequiredArgsConstructor
public class FakerData {
    private final ProductRepository productRepository;
    private final ProductVariantRepository productVariantRepository;
    private final ProductCollectionRepository productCollectionRepository;

    @PostConstruct
    public void initData() {
       if (false){
           Faker faker = new Faker();

           // Create collections
           Set<ProductCollection> collections = new HashSet<>();
           for (int i = 0; i < 10; i++) {
               ProductCollection collection = new ProductCollection();
               collection.setCollectionName(faker.commerce().department());
               collections.add(productCollectionRepository.save(collection));
           }

           // Create products
           for (int i = 0; i < 30; i++) {
               Product product = new Product();
               product.setName(faker.commerce().productName());
               product.setMainImageUrl(faker.internet().url());
               product.setSubImageUrl(faker.internet().url());
               product.setSizeChartUrl(faker.internet().url());
               product.setCategory(Category.values()[faker.random().nextInt(Category.values().length)]);
//               product.setCollections(collections);
               product.setPrice(BigDecimal.valueOf(faker.number().randomDouble(2, 10, 100)));
               product = productRepository.save(product);

               // Create product variants
               for (Size size : Size.values()) {
                   Set<Color> usedColors = new HashSet<>();
                   while (usedColors.size() < 3) {
                       Color color = Color.values()[faker.random().nextInt(Color.values().length)];
                       if (!usedColors.contains(color)) {
                           usedColors.add(color);
                           ProductVariant variant = new ProductVariant();
                           variant.setProduct(product);
                           variant.setSku(faker.code().ean13());
                           variant.setColor(color);
                           variant.setSize(size);
                           variant.setQuantity(faker.number().numberBetween(1, 100));
                           variant.setSoldQuantity(faker.number().numberBetween(0, 50));
                           variant.setDiscountPercentage(BigDecimal.valueOf(faker.number().randomDouble(2, 0, 30)));
                           variant.setCreatedDate(LocalDate.now());
                           variant.setActive(faker.bool().bool());
                           variant.setNewProduct(faker.bool().bool());
                           variant.setBestSeller(faker.bool().bool());

                           // Ensure at least 4 images
                           Set<String> images = new HashSet<>();
                           while (images.size() < 4) {
                               images.add(faker.internet().url());
                           }
//                           variant.setProductImages(images);

                           productVariantRepository.save(variant);
                       }
                   }
               }
           }
       }
    }
}
