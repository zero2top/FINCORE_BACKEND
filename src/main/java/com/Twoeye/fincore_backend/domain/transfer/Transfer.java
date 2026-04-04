package com.Twoeye.fincore_backend.domain.transfer;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transfers", indexes = {
        @Index(name = "idx_transfer_from_account_id", columnList = "fromAccountId")
})
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
@EntityListeners(AuditingEntityListener.class)
public class Transfer {

    @Id
    @UuidGenerator
    @Column(name = "transfer_id", updatable = false)
    private String transferId;

    @Column(nullable = false)
    private String fromAccountId;

    @Column(nullable = false)
    private String toAccountNumber;

    @Column(nullable = false, precision = 18, scale = 2)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private TransferStatus status = TransferStatus.PENDING;

    @Column
    private String failReason;

    @Column(unique = true,nullable = false)
    private String idempotencyKey;


    @CreatedDate
    @Column(name = "requested_at", updatable = false)
    private LocalDateTime requestedAt;

    @Column
    private LocalDateTime completedAt;

    public void complete(LocalDateTime completedAt) {
        this.status = TransferStatus.COMPLETED;
        this.completedAt = completedAt;
    }

    public void fail(String failReason) {
        this.status = TransferStatus.FAILED;
        this.failReason = failReason;
    }
}