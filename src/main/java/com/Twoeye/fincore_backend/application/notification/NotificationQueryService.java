package com.Twoeye.fincore_backend.application.notification;

import com.Twoeye.fincore_backend.domain.notification.Notification;
import com.Twoeye.fincore_backend.domain.notification.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationQueryService {

    private final NotificationRepository notificationRepository;

    // size+1개 조회 → hasNext 판별은 컨트롤러/서비스에서
    public List<Notification> getNotifications(String userId, LocalDateTime cursor, int size) {
        return notificationRepository.findByUserId(userId, cursor, size + 1);
    }

    public List<Notification> getUnreadNotifications(String userId, LocalDateTime cursor, int size) {
        return notificationRepository.findUnreadByUserId(userId, cursor, size + 1);
    }

    public long countUnread(String userId) {
        return notificationRepository.countUnreadByUserId(userId);
    }
}
