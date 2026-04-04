package com.Twoeye.fincore_backend.entity;

import com.Twoeye.fincore_backend.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class Product {

    @Id
    @UuidGenerator
    @Column(name = "product_id")
    private String productId;

    @Column(nullable = false, unique = true)
    private String name; // 상품명

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type; // SAVINGS / DEPOSIT / LOAN

    @Column(name = "interest_rate", nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate; // 이자율 (예: 3.55)

    @Column(name = "min_period", nullable = false)
    private Integer minPeriod; // 최소 가입 기간 (개월)

    @Column(name = "max_period", nullable = false)
    private Integer maxPeriod; // 최대 가입 기간 (개월)

    @Column(name = "min_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal minAmount; // 최소 가입 금액

    @Column(name = "max_amount", nullable = false, precision = 18, scale = 2)
    private BigDecimal maxAmount; // 최대 가입 금액

    @Column(name = "is_active", nullable = false)
    @Builder.Default
    private boolean isActive = true; // 상품 판매 여부
}