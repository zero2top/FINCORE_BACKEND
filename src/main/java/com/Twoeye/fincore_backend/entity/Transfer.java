package com.Twoeye.fincore_backend.entity;

import com.Twoeye.fincore_backend.enums.TransferStatus;
import jakarta.persistence.*;
import lombok.*;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long fromAccountId;

    @Column(nullable = false)
    private Long toAccountId;

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
