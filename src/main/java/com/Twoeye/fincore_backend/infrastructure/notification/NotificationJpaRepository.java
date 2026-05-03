package com.Twoeye.fincore_backend.infrastructure.notification;

import com.Twoeye.fincore_backend.domain.notification.Notification;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface NotificationJpaRepository extends JpaRepository<Notification, String> {

    @Query("SELECT n FROM Notification n WHERE n.userId = :userId AND (:cursor IS NULL OR n.createdAt < :cursor) ORDER BY n.createdAt DESC")
    List<Notification> findCursorByUserId(
            @Param("userId") String userId,
            @Param("cursor") LocalDateTime cursor,
            Pageable pageable
    );

    @Query("SELECT n FROM Notification n WHERE n.userId = :userId AND n.isRead = false AND (:cursor IS NULL OR n.createdAt < :cursor) ORDER BY n.createdAt DESC")
    List<Notification> findCursorUnreadByUserId(
            @Param("userId") String userId,
            @Param("cursor") LocalDateTime cursor,
            Pageable pageable
    );

    long countByUserIdAndIsReadFalse(String userId);

    @Modifying
    @Query("UPDATE Notification n SET n.isRead = true WHERE n.notificationId = :notificationId")
    void updateIsReadTrueById(@Param("notificationId") String notificationId);

    @Modifying
    @Query("UPDATE Notification n SET n.isRead = true WHERE n.userId = :userId AND n.isRead = false")
    void updateAllIsReadTrueByUserId(@Param("userId") String userId);
}
