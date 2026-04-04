package com.Twoeye.fincore_backend.domain.transaction;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transactions", indexes = {
        @Index(name = "idx_transaction_account_id", columnList = "account_id")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Transaction {

    @Id
    @UuidGenerator
    @Column(name = "transaction_id")
    private String transactionId;

    @Column(name = "account_id", nullable = false, updatable = false)
    private String accountId;

    @Column(name = "transfer_id", updatable = false)
    private String transferId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private TransactionType type; // DEPOSIT / WITHDRAWAL / TRANSFER

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amount; // 거래 금액

    @Column(name = "balance_after", nullable = false, precision = 18, scale = 2)
    private BigDecimal balanceAfter; // 거래 후 잔액

    @Column
    private String counterparty; // 상대방 계좌번호 또는 이름 (이체 시)

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;
}