package com.Twoeye.fincore_backend.enums;

import lombok.Getter;

@Getter
public enum SubscriptionStatus {
    ACTIVE,      // 가입 중 (운용 중)
    MATURED,     // 만기 완료
    CANCELLED,   // 중도 해지
    PENDING      // 가입 처리 중
}
