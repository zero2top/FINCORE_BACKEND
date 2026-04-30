package com.Twoeye.fincore_backend.domain.subscription.exception;

import com.Twoeye.fincore_backend.domain.common.exception.DomainException;

public class SubscriptionAlreadyCancelledException extends DomainException {

    public SubscriptionAlreadyCancelledException(String subscriptionId) {
        super("이미 해지된 구독 상품입니다. subscriptionId=" + subscriptionId);
    }
}
