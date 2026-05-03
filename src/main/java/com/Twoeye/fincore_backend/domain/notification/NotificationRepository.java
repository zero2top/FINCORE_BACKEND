package com.Twoeye.fincore_backend.domain.notification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface NotificationRepository {
    Notification save(Notification notification);

    Optional<Notification> findById(String notificationId);

    // cursor: null이면 첫 페이지, size+1개 조회해서 hasNext 판별
    List<Notification> findByUserId(String userId, LocalDateTime cursor, int size);

    List<Notification> findUnreadByUserId(String userId, LocalDateTime cursor, int size);

    long countUnreadByUserId(String userId);

    void markAsRead(String notificationId);

    void markAllAsReadByUserId(String userId);

    void deleteById(String notificationId);
}
