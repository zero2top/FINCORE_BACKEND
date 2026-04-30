package com.Twoeye.fincore_backend.domain.transaction.exception;

import com.Twoeye.fincore_backend.domain.common.exception.EntityNotFoundException;

public class TransactionNotFoundException extends EntityNotFoundException {

    public TransactionNotFoundException(String transactionId) {
        super("거래 내역을 찾을 수 없습니다. transactionId=" + transactionId);
    }
}
