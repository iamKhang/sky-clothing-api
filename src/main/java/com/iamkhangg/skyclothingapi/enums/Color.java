package com.iamkhangg.skyclothingapi.enums;

import lombok.Getter;

@Getter
public enum Color {
    BABY_BLUE("#0000FF"),
    BEIGE("#F5F5DC"),
    BEIGE_CHARCOAL("#D3BFAE"),
    BLACK("#000000"),
    BLACK_RED("#FF0000"),
    BLACK_LIGHT_BROWN("#4B3621"),
    BLACK_WHITE("#808080"),
    BLUE("#0000FF"),
    BLUE_TURQUOISE("#40E0D0"),
    BROWN("#A52A2A"),
    CREAM("#FFFDD0"),
    DARK_BLUE("#00008B"),
    DARK_BROWN("#654321"),
    DARK_GREEN("#006400"),
    DARK_RED("#8B0000"),
    DARK_GREY("#A9A9A9"),
    DUSTY_BRICK("#B22222"),
    FOREST_GREEN("#228B22"),
    GREEN("#008000"),
    GREEN_CREAM("#C5E384"),
    GREY("#808080"),
    HAZY_WAVES("#D3D3D3"),
    ICEBERG_BLUE("#1E90FF"),
    LIGHT_BLUE("#ADD8E6"),
    LIGHT_BROWN("#A0522D"),
    LIGHT_GREY("#D3D3D3"),
    LIGHT_PINK("#FFB6C1"),
    LILAS("#C8A2C8"),
    MID_BROWN("#7B3F00"),
    MINT("#98FF98"),
    MULBERRY("#C54B8C"),
    MUSHROOM("#C7B097"),
    NAVY("#000080"),
    OLIVE("#808000"),
    OLIVE_GREEN("#556B2F"),
    ORANGE("#FFA500"),
    PAPER_GREEN("#32CD32"),
    PINK("#FFC0CB"),
    PINK_VELVET("#FF69B4"),
    RED("#FF0000"),
    RED_CORAL("#FF7F50"),
    TAN("#D2B48C"),
    VANILLA("#F3E5AB"),
    VINTAGE_BLACK("#0D0D0D"),
    WHITE("#FFFFFF"),
    WHITE_LIGHT_BROWN("#EDEADE"),
    YELLOW("#FFFF00");

    // Phương thức để lấy mã màu hex
    private final String hexCode; // Mã màu hex

    // Constructor để gán giá trị mã hex cho từng màu
    Color(String hexCode) {
        this.hexCode = hexCode;
    }

}
