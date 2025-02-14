package com.iamkhangg.skyclothingapi.enums;

public enum Category {
    // Top categories
    TOP_TSHIRT("TOP", "TSHIRT"),
    TOP_SHIRT("TOP", "SHIRT"),
    TOP_POLO("TOP", "POLO"),

    // Bottom categories
    BOTTOM_PANT("BOTTOM", "PANT"),
    BOTTOM_SHORTPANT("BOTTOM", "SHORTPANT"),

    // Outerwear categories
    OUTERWEAR_HOODIE("OUTERWEAR", "HOODIE"),
    OUTERWEAR_HOODIE_ZIPPER("OUTERWEAR", "HOODIE ZIPPER"),
    OUTERWEAR_SWEATER("OUTERWEAR", "SWEATER"),
    OUTERWEAR_JACKET("OUTERWEAR", "JACKET"),
    OUTERWEAR_VARSITY("OUTERWEAR", "VARSITY"),
    OUTERWEAR_CARDIGAN("OUTERWEAR", "CARDIGAN"),

    // Accessories categories
    ACCESSORIES_CAP("ACCESSORIES", "CAP"),
    ACCESSORIES_MINI_SHOULDER_BAG("ACCESSORIES", "MINI SHOULDER BAG"),
    ACCESSORIES_TOTE_BAG("ACCESSORIES", "TOTE BAG"),
    ACCESSORIES_WALLET("ACCESSORIES", "WALLET"),
    ACCESSORIES_SOCK("ACCESSORIES", "SOCK"),
    ACCESSORIES_SANDAL("ACCESSORIES", "SANDAL");

    private final String mainCategory;
    private final String subCategory;

    Category(String mainCategory, String subCategory) {
        this.mainCategory = mainCategory;
        this.subCategory = subCategory;
    }

    public String getMainCategory() {
        return mainCategory;
    }

    public String getSubCategory() {
        return subCategory;
    }

    public static Category fromString(String value) {
        try {
            return Category.valueOf(value.toUpperCase().replace(" ", "_"));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid category: " + value);
        }
    }

    public static Category fromMainAndSubCategory(String main, String sub) {
        for (Category category : Category.values()) {
            if (category.mainCategory.equalsIgnoreCase(main) && 
                category.subCategory.equalsIgnoreCase(sub)) {
                return category;
            }
        }
        throw new IllegalArgumentException("Invalid category combination: " + main + " - " + sub);
    }
}