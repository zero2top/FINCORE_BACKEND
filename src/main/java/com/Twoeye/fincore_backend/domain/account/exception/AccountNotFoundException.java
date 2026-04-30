package com.Twoeye.fincore_backend.domain.account.exception;

import com.Twoeye.fincore_backend.domain.common.exception.EntityNotFoundException;

public class AccountNotFoundException extends EntityNotFoundException {

    public AccountNotFoundException(String accountId) {
        super("계좌를 찾을 수 없습니다. accountId=" + accountId);
    }
}
