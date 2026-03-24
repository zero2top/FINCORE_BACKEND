package com.Twoeye.fincore_backend.entity;

import com.Twoeye.fincore_backend.enums.AccountStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor // 빌더나 테스트를 위한 전체 생성자
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    @Column(unique = true, nullable = false)
    private String accountNumber;

    @Column(nullable = false)
    private String memberId;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private Long balance; // 잔액

    @Column(nullable = false)
    private int dailyTransferAmount;

    @Column(nullable = false)
    private AccountStatus status;

    @Column(nullable = false)
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY) // 여러 계좌가 한 명의 유저에게 속함
    @JoinColumn(name = "user_id") //User의 user_id와 연결됨.
    private User user;
}
