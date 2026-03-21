package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "ProductSubscription")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder

public class ProductSubscription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long productId;

    @Column(nullable = false)
    private Long memberId;

    @Column(nullable = false)
    private Long accountId;

    @Column(nullable = false)
    private BigDecimal amount;

    //@Column(nullable = false)
    //private int period;

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate maturityDate;

//    @Column(nullable = false)
//    private enum status;

}
