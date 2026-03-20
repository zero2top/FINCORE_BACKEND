package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users") // DB에는 users라는 이름으로 테이블이 생깁니다.
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // 고유 번호 (자동 증가)

    @Column(nullable = false, unique = true)
    private String email; // 이메일 (중복 불가)

    @Column(nullable = false)
    private String password; // 비밀번호

    @Column(nullable = false)
    private String name; // 이름
}