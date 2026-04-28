package com.Twoeye.fincore_backend.infrastructure.notification;

import com.Twoeye.fincore_backend.domain.notification.Notification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface NotificationJpaRepository extends JpaRepository<Notification, String> {

    // 사용자별 알림 (최신순)
    Page<Notification> findByUserIdOrderByCreatedAtDesc(String userId, Pageable pageable);

    // 사용자별 안 읽은 알림
    Page<Notification> findByUserIdAndIsReadFalseOrderByCreatedAtDesc(String userId, Pageable pageable);

    // 안 읽은 알림 개수
    long countByUserIdAndIsReadFalse(String userId);

    // 단건 읽음 처리
    @Modifying
    @Query("UPDATE Notification n SET n.isRead = true WHERE n.notificationId = :notificationId")
    void updateIsReadTrueById(@Param("notificationId") String notificationId);

    // 사용자의 모든 안 읽은 알림 읽음 처리
    @Modifying
    @Query("UPDATE Notification n SET n.isRead = true WHERE n.userId = :userId AND n.isRead = false")
    void updateAllIsReadTrueByUserId(@Param("userId") String userId);
}