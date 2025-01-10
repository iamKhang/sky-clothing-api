package com.iamkhangg.skyclothingapi.utils;

import java.util.List;

import com.iamkhangg.skyclothingapi.entities.ProductVariant;
import com.iamkhangg.skyclothingapi.enums.Color;
import com.iamkhangg.skyclothingapi.enums.Size;

public class SkuGenerator {

    public static String generateSku(String productName, List<ProductVariant> allVariants, Size size, Color color) {
        String prefix = generatePrefix(productName);
        int sequenceNumber = getNextSequenceNumber(prefix, allVariants);
        String sizeCode = size.name();
        String colorCode = color.name().substring(0, 2).toUpperCase();

        return String.format("%s-%04d-%s-%s", prefix, sequenceNumber, sizeCode, colorCode);
    }

    private static String generatePrefix(String productName) {
        if (productName != null) {
            String name = productName.toUpperCase();
            if (name.length() >= 3) {
                return name.substring(0, 3);
            } else {
                return (name + "XXX").substring(0, 3);
            }
        }
        return "XXX";
    }

    private static int getNextSequenceNumber(String prefix, List<ProductVariant> allVariants) {
        int maxSequence = allVariants.stream()
                .filter(variant -> variant.getSku() != null && variant.getSku().startsWith(prefix))
                .mapToInt(variant -> {
                    String[] parts = variant.getSku().split("-");
                    if (parts.length > 1) {
                        try {
                            return Integer.parseInt(parts[1]);
                        } catch (NumberFormatException e) {
                            return 0; // Default to 0 if parsing fails
                        }
                    }
                    return 0; // Default to 0 if the format is incorrect
                })
                .max()
                .orElse(0);
        return maxSequence + 1;
    }
} 