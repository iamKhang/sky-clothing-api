package com.iamkhangg.skyclothingapi.entities;

import com.iamkhangg.skyclothingapi.enums.DiscountType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "discount_codes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiscountCode {
    @Id
    @UuidGenerator
    @Column(name = "discount_id")
    private String discountId;

    @Column(nullable = false, unique = true)
    private String code;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "discount_type")
    private DiscountType discountType;

    @Column(nullable = false, name = "discount_value")
    private BigDecimal discountValue;

    @Column(name = "min_order_value")
    private BigDecimal minOrderValue;

    @Column(name = "max_discount_value")
    private BigDecimal maxDiscountValue;

    @Column(name = "max_use")
    private Integer maxUse;

    @Column(nullable = false, name = "start_date")
    private LocalDate startDate;

    @Column(nullable = false, name = "end_date")
    private LocalDate endDate;

    @Override
    public String toString() {
        return "DiscountCode{" +
                "discountId='" + discountId + '\'' +
                ", code='" + code + '\'' +
                ", discountType=" + discountType +
                ", discountValue=" + discountValue +
                ", minOrderValue=" + minOrderValue +
                ", maxDiscountValue=" + maxDiscountValue +
                ", maxUse=" + maxUse +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
