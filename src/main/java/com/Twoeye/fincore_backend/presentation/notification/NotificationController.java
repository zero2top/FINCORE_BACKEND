package com.Twoeye.fincore_backend.presentation.notification;

import com.Twoeye.fincore_backend.application.notification.NotificationCommandService;
import com.Twoeye.fincore_backend.application.notification.NotificationQueryService;
import com.Twoeye.fincore_backend.domain.notification.Notification;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import com.Twoeye.fincore_backend.presentation.common.CursorPageResponse;
import com.Twoeye.fincore_backend.presentation.notification.dto.NotificationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationQueryService notificationQueryService;
    private final NotificationCommandService notificationCommandService;

    @GetMapping("/user/{userId}")
    public ApiResponse<CursorPageResponse<NotificationResponse>> getNotifications(
            @PathVariable String userId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime cursor,
            @RequestParam(defaultValue = "20") int size) {

        List<Notification> result = notificationQueryService.getNotifications(userId, cursor, size);
        return ApiResponse.ok(toCursorPage(result, size));
    }

    @GetMapping("/user/{userId}/unread")
    public ApiResponse<CursorPageResponse<NotificationResponse>> getUnreadNotifications(
            @PathVariable String userId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime cursor,
            @RequestParam(defaultValue = "20") int size) {

        List<Notification> result = notificationQueryService.getUnreadNotifications(userId, cursor, size);
        return ApiResponse.ok(toCursorPage(result, size));
    }

    @GetMapping("/user/{userId}/unread/count")
    public ApiResponse<Long> countUnread(@PathVariable String userId) {
        return ApiResponse.ok(notificationQueryService.countUnread(userId));
    }

    @PatchMapping("/{notificationId}/read")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void markAsRead(@PathVariable String notificationId) {
        notificationCommandService.markAsRead(notificationId);
    }

    @PatchMapping("/user/{userId}/read-all")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void markAllAsRead(@PathVariable String userId) {
        notificationCommandService.markAllAsRead(userId);
    }

    @DeleteMapping("/{notificationId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteNotification(@PathVariable String notificationId) {
        notificationCommandService.deleteNotification(notificationId);
    }

    private CursorPageResponse<NotificationResponse> toCursorPage(List<Notification> result, int size) {
        boolean hasNext = result.size() > size;
        List<NotificationResponse> content = result.stream()
                .limit(size)
                .map(NotificationResponse::from)
                .toList();
        String nextCursor = hasNext ? content.get(content.size() - 1).createdAt().toString() : null;
        return CursorPageResponse.of(content, nextCursor, hasNext, size);
    }
}
