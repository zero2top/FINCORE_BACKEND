package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "users")
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

    private String email; // 선택 사항 (알림용)
}