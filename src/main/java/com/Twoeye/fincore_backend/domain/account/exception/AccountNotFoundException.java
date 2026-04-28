package com.Twoeye.fincore_backend.domain.account.exception;

public class AccountNotFoundException extends RuntimeException {

    public AccountNotFoundException(String accountId) {
        super("계좌를 찾을 수 없습니다. accountId=" + accountId);
    }
}
