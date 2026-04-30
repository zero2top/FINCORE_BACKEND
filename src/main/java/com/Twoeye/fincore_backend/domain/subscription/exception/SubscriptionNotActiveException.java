package com.Twoeye.fincore_backend.domain.subscription.exception;

import com.Twoeye.fincore_backend.domain.common.exception.DomainException;
import com.Twoeye.fincore_backend.domain.subscription.SubscriptionStatus;

public class SubscriptionNotActiveException extends DomainException {

    public SubscriptionNotActiveException(String subscriptionId, SubscriptionStatus status) {
        super("활성 상태의 구독 상품이 아닙니다. subscriptionId=" + subscriptionId + ", 현재 상태=" + status);
    }
}
