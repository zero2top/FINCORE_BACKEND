package com.Twoeye.fincore_backend.entity;

import com.Twoeye.fincore_backend.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Transfers")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Transfer {

    @Id
    @UuidGenerator
    private String transferId;

    @Column(nullable = false)
    private String fromAccountId;

    @Column(nullable = false)
    private String toAccountNumber;

    @Column(nullable = false)
    private BigDecimal amount;

    @Column(nullable = false)
    private TransferStatus status;

    @Column
    private String failReason;

    @Column(unique = true,nullable = false)
    private String idempotencyKey;

    @Column(nullable = false)
    private LocalDate requestedTime;

    @Column(nullable = false)
    private LocalDate completedTime;

}
