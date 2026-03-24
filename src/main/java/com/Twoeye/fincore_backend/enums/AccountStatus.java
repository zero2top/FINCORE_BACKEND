package com.Twoeye.fincore_backend.enums;

import lombok.Getter;

@Getter
public enum AccountStatus {
    ACTIVE,   // 정상
    DORMANT,  // 휴면 (장기 미사용)
    CLOSED    // 해지
}
