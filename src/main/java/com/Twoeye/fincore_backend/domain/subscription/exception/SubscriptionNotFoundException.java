package com.Twoeye.fincore_backend.domain.subscription.exception;

import com.Twoeye.fincore_backend.domain.common.exception.EntityNotFoundException;

public class SubscriptionNotFoundException extends EntityNotFoundException {

    public SubscriptionNotFoundException(String subscriptionId) {
        super("구독 상품을 찾을 수 없습니다. subscriptionId=" + subscriptionId);
    }
}
