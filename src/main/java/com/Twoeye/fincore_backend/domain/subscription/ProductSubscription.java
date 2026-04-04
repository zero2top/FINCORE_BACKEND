package com.Twoeye.fincore_backend.domain.subscription;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDate;

@Entity
@Table(name = "product_subscription")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class ProductSubscription {

    @Id
    @UuidGenerator
    @Column(name = "subscription_id", updatable = false, nullable = false)
    private String subscriptionId;

    @Column(name = "product_id", nullable = false, updatable = false)
    private String productId;

    @Column(name = "user_id", nullable = false, updatable = false)
    private String userId;

    @Column(name = "account_id", nullable = false, updatable = false)
    private String accountId;

    @Column(nullable = false, precision = 15, scale = 2)
    private BigDecimal amount;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false, updatable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate maturityDate;

    // 갱신형 상품일 때만 값 있음, 아니면 null
    @Column
    private LocalDate nextRenewAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private SubscriptionStatus status;

    public void renew(LocalDate nextRenewAt) {
        this.nextRenewAt = nextRenewAt;
    }

    public void mature() {
        this.status = SubscriptionStatus.MATURED;
        this.nextRenewAt = null;
    }

    public void cancel() {
        this.status = SubscriptionStatus.CANCELLED;
        this.nextRenewAt = null;
    }
}