package com.Twoeye.fincore_backend.application.account;

import com.Twoeye.fincore_backend.domain.account.Account;
import com.Twoeye.fincore_backend.domain.account.AccountRepository;
import com.Twoeye.fincore_backend.domain.account.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AccountQueryService {

    private final AccountRepository accountRepository;

    public Account getAccount(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));
    }

    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new AccountNotFoundException(accountNumber));
    }

    public List<Account> getAccountsByUserId(String userId) {
        return accountRepository.findAllByUserId(userId);
    }
}
