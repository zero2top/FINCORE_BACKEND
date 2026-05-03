package com.Twoeye.fincore_backend.domain.notification.exception;

import com.Twoeye.fincore_backend.domain.common.exception.EntityNotFoundException;

public class NotificationNotFoundException extends EntityNotFoundException {

    public NotificationNotFoundException(String notificationId) {
        super("알림을 찾을 수 없습니다. notificationId=" + notificationId);
    }
}
