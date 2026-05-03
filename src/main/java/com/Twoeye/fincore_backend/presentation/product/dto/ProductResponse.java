package com.Twoeye.fincore_backend.presentation.product.dto;

import com.Twoeye.fincore_backend.domain.product.Product;

import java.math.BigDecimal;

public record ProductResponse(
        String productId,
        String name,
        String type,
        BigDecimal interestRate,
        Integer minPeriod,
        Integer maxPeriod,
        BigDecimal minAmount,
        BigDecimal maxAmount,
        boolean isActive
) {
    public static ProductResponse from(Product product) {
        return new ProductResponse(
                product.getProductId(),
                product.getName(),
                product.getType().name(),
                product.getInterestRate(),
                product.getMinPeriod(),
                product.getMaxPeriod(),
                product.getMinAmount(),
                product.getMaxAmount(),
                product.isActive()
        );
    }
}
