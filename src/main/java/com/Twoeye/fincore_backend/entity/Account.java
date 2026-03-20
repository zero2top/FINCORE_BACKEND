package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "accounts")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor // 빌더나 테스트를 위한 전체 생성자
@Builder
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Account 자체의 고유 PK (1, 2, 3...)

    @Column(unique = true, nullable = false)
    private String accountNumber; // 실제 계좌번호 (예: 110-123-456)

    private Long balance; // 잔액

    @ManyToOne(fetch = FetchType.LAZY) // 여러 계좌가 한 명의 유저에게 속함
    @JoinColumn(name = "user_id") //User의 user_id와 연결됨.
    private User user;
}
