package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA를 위한 최소한의 문 열어두기
@AllArgsConstructor // 빌더나 테스트를 위한 전체 생성자
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String loginId; // 로그인용 아이디, 중복 불가

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name; // 실명 (송금 시 필요)

    @Column(unique = true, nullable = false)
    private String phoneNumber; // 휴대폰 번호 (본인 인증 및 연락용), 중복 불가

    @Column(unique = true, nullable = false)
    private String email; // 이메일
}