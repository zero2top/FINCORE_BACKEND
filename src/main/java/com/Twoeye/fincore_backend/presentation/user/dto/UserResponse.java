package com.Twoeye.fincore_backend.presentation.user.dto;

import com.Twoeye.fincore_backend.domain.user.User;

import java.time.LocalDateTime;

public record UserResponse(
        String userId,
        String loginId,
        String name,
        String phoneNumber,
        String status,
        LocalDateTime createdAt
) {
    public static UserResponse from(User user) {
        return new UserResponse(
                user.getUserId(),
                user.getLoginId(),
                user.getName(),
                user.getPhoneNumber(),
                user.getStatus().name(),
                user.getCreatedAt()
        );
    }
}
