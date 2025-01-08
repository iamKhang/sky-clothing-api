package com.iamkhangg.skyclothingapi.enums;

public enum Category {
    TOP, BOTTOM, OUTERWEAR, BAG, ACCESSORIES;
    
    public static Category fromString(String value) {
        try {
            return Category.valueOf(value.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + value);
        }
    }
}