package com.Twoeye.fincore_backend.infrastructure.notification;

import com.Twoeye.fincore_backend.domain.notification.Notification;
import com.Twoeye.fincore_backend.domain.notification.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class NotificationRepositoryImpl implements NotificationRepository {

    private final NotificationJpaRepository jpaRepository;

    @Override
    public Notification save(Notification notification) {
        return jpaRepository.save(notification);
    }

    @Override
    public Optional<Notification> findById(String notificationId) {
        return jpaRepository.findById(notificationId);
    }

    @Override
    public List<Notification> findByUserId(String userId, LocalDateTime cursor, int size) {
        return jpaRepository.findCursorByUserId(userId, cursor, PageRequest.of(0, size));
    }

    @Override
    public List<Notification> findUnreadByUserId(String userId, LocalDateTime cursor, int size) {
        return jpaRepository.findCursorUnreadByUserId(userId, cursor, PageRequest.of(0, size));
    }

    @Override
    public long countUnreadByUserId(String userId) {
        return jpaRepository.countByUserIdAndIsReadFalse(userId);
    }

    @Override
    public void markAsRead(String notificationId) {
        jpaRepository.updateIsReadTrueById(notificationId);
    }

    @Override
    public void markAllAsReadByUserId(String userId) {
        jpaRepository.updateAllIsReadTrueByUserId(userId);
    }

    @Override
    public void deleteById(String notificationId) {
        jpaRepository.deleteById(notificationId);
    }
}
