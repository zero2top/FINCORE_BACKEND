package com.Twoeye.fincore_backend.presentation.common;

import java.util.List;

public record CursorPageResponse<T>(
        List<T> content,
        String nextCursor,
        boolean hasNext,
        int size
) {
    public static <T> CursorPageResponse<T> of(List<T> content, String nextCursor, boolean hasNext, int size) {
        return new CursorPageResponse<>(content, nextCursor, hasNext, size);
    }
}
