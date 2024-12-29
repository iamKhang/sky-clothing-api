package com.iamkhangg.skyclothingapi.enums;

import lombok.Getter;

@Getter
public enum Color {
    RED("#C62300"),
    GREEN("#3E7B27"),
    BLUE("#81BFDA"),
    YELLOW("#FFB200"),
    BLACK("#2A3335"),
    WHITE("#FFFFFF"),
    ORANGE("#EB5B00"),
    PINK("#D91656");

    // Phương thức để lấy mã màu hex
    private final String hexCode;  // Mã màu hex

    // Constructor để gán giá trị mã hex cho từng màu
    Color(String hexCode) {
        this.hexCode = hexCode;
    }

}
