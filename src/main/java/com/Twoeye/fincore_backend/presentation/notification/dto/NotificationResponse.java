package com.Twoeye.fincore_backend.presentation.notification.dto;

import com.Twoeye.fincore_backend.domain.notification.Notification;

import java.time.LocalDateTime;

public record NotificationResponse(
        String notificationId,
        String userId,
        String type,
        String title,
        String message,
        boolean isRead,
        LocalDateTime createdAt
) {
    public static NotificationResponse from(Notification notification) {
        return new NotificationResponse(
                notification.getNotificationId(),
                notification.getUserId(),
                notification.getType().name(),
                notification.getTitle(),
                notification.getMessage(),
                notification.isRead(),
                notification.getCreatedAt()
        );
    }
}
