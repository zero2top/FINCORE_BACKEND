package com.Twoeye.fincore_backend.presentation.subscription.dto;

import com.Twoeye.fincore_backend.domain.subscription.ProductSubscription;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public record SubscriptionResponse(
        String subscriptionId,
        String productId,
        String userId,
        String accountId,
        BigDecimal amount,
        LocalDate startDate,
        LocalDate maturityDate,
        LocalDate nextRenewAt,
        String status,
        LocalDateTime createdAt
) {
    public static SubscriptionResponse from(ProductSubscription subscription) {
        return new SubscriptionResponse(
                subscription.getSubscriptionId(),
                subscription.getProductId(),
                subscription.getUserId(),
                subscription.getAccountId(),
                subscription.getAmount(),
                subscription.getStartDate(),
                subscription.getMaturityDate(),
                subscription.getNextRenewAt(),
                subscription.getStatus().name(),
                subscription.getCreatedAt()
        );
    }
}
