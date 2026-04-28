package com.Twoeye.fincore_backend.domain.notification;

import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NotificationRepository {
    Notification save(Notification notification);

    Optional<Notification> findById(String notificationId);

    Page<Notification> findByUserId(String userId, Pageable pageable);

    Page<Notification> findUnreadByUserId(String userId, Pageable pageable);

    long countUnreadByUserId(String userId);

    void markAsRead(String notificationId);

    void markAllAsReadByUserId(String userId);

    void deleteById(String notificationId);
}
