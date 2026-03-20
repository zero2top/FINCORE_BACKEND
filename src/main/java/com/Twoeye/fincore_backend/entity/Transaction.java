package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "transactions")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA를 위한 최소한의 문 열어두기
@AllArgsConstructor // 빌더나 테스트를 위한 전체 생성자
@Builder
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // Transaction의 자체 고유 id

    @Column(unique = true, nullable = false)
    private String accountNumber; // 실제 계좌번호 (예: 110-123-456)

    private Long balance; // 잔액

    @ManyToOne(fetch = FetchType.LAZY) // 여러 계좌가 한 명의 유저에게 속함
    @JoinColumn(name = "user_id") //User의 user_id와 연결됨.
    private User user;
}
