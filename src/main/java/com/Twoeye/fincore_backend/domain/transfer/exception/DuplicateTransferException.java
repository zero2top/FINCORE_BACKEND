package com.Twoeye.fincore_backend.domain.transfer.exception;

import com.Twoeye.fincore_backend.domain.common.exception.DomainException;

public class DuplicateTransferException extends DomainException {

    public DuplicateTransferException(String idempotencyKey) {
        super("이미 처리된 이체 요청입니다. idempotencyKey=" + idempotencyKey);
    }
}
