package com.Twoeye.fincore_backend.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;


@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@EntityListeners(AuditingEntityListener.class)
@Table(name = "notifications")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user; // 알림을 받는 사용자

    @Column(nullable = false)
    private String message; // 알림 내용

    @Column(nullable = false)
    private boolean isRead = false; // 읽음 여부 (기본값은 안읽음)

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt; // 알림 발생 시간
}
