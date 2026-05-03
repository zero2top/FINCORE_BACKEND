package com.Twoeye.fincore_backend.application.notification;

import com.Twoeye.fincore_backend.domain.notification.NotificationRepository;
import com.Twoeye.fincore_backend.domain.notification.exception.NotificationNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class NotificationCommandService {

    private final NotificationRepository notificationRepository;

    public void markAsRead(String notificationId) {
        notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotificationNotFoundException(notificationId));
        notificationRepository.markAsRead(notificationId);
    }

    public void markAllAsRead(String userId) {
        notificationRepository.markAllAsReadByUserId(userId);
    }

    public void deleteNotification(String notificationId) {
        notificationRepository.findById(notificationId)
                .orElseThrow(() -> new NotificationNotFoundException(notificationId));
        notificationRepository.deleteById(notificationId);
    }
}
