package com.Twoeye.fincore_backend.entity;

import com.Twoeye.fincore_backend.enums.ProductType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Table(name = "products")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String productName; // 상품명 (예: "싸이월드 정기예금", "청년희망적금")

    @Column(nullable = false)
    private String description; // 상품 설명

    @Column(nullable = false, precision = 5, scale = 2)
    private BigDecimal interestRate; // 이자율 (예: 3.55%)

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProductType type; // 상품 유형 (SAVINGS, DEPOSIT, LOAN 등)

    @Column(nullable = false)
    private Long minAmount; // 최소 가입 금액

    @Column(nullable = false)
    private Integer periodMonths; // 가입 기간 (단위: 개월)
}