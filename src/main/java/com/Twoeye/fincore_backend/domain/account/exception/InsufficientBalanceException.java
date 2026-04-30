package com.Twoeye.fincore_backend.domain.account.exception;

import com.Twoeye.fincore_backend.domain.common.exception.DomainException;

import java.math.BigDecimal;

public class InsufficientBalanceException extends DomainException {

    public InsufficientBalanceException(String accountId, BigDecimal balance, BigDecimal amount) {
        super("잔액이 부족합니다. accountId=" + accountId
                + ", 현재 잔액=" + balance
                + ", 요청 금액=" + amount);
    }
}
