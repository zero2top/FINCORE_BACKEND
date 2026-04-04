package com.Twoeye.fincore_backend.domain.account;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Account {

    @Id
    @UuidGenerator
    @Column(name = "account_id")
    private String accountId;

    @Column(name = "account_number", unique = true, nullable = false)
    private String accountNumber;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Column(name = "product_id", nullable = false)
    private String productId;

    @Column(nullable = false, precision = 18, scale = 2)
    @Builder.Default
    private BigDecimal balance = BigDecimal.ZERO;

    @Column(name = "daily_transfer_amount", nullable = false, precision = 18, scale = 2)
    @Builder.Default
    private BigDecimal dailyTransferAmount = new BigDecimal("3000000");

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private AccountStatus status = AccountStatus.ACTIVE;

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    public void deposit(BigDecimal amount) {
        this.balance = this.balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {
        this.balance = this.balance.subtract(amount);
    }

    public void close() {
        this.status = AccountStatus.CLOSED;
    }

    public void dormant() {
        this.status = AccountStatus.DORMANT;
    }
}