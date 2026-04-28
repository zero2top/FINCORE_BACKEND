package com.Twoeye.fincore_backend.domain.account.exception;

public class AccountNotActiveException extends RuntimeException {

    public AccountNotActiveException(String accountId) {
        super("활성 상태가 아닌 계좌입니다. accountId=" + accountId);
    }
}
