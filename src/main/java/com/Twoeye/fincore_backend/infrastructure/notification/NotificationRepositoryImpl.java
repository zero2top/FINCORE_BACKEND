package com.Twoeye.fincore_backend.infrastructure.notification;

import com.Twoeye.fincore_backend.domain.notification.Notification;
import com.Twoeye.fincore_backend.domain.notification.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

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
    public Page<Notification> findByUserId(String userId, Pageable pageable) {
        return jpaRepository.findByUserIdOrderByCreatedAtDesc(userId, pageable);
    }

    @Override
    public Page<Notification> findUnreadByUserId(String userId, Pageable pageable) {
        return jpaRepository.findByUserIdAndIsReadFalseOrderByCreatedAtDesc(userId, pageable);
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