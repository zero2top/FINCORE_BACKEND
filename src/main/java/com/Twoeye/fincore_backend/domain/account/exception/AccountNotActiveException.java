package com.Twoeye.fincore_backend.domain.account.exception;

import com.Twoeye.fincore_backend.domain.common.exception.DomainException;

public class AccountNotActiveException extends DomainException {

    public AccountNotActiveException(String accountId) {
        super("활성 상태가 아닌 계좌입니다. accountId=" + accountId);
    }
}
