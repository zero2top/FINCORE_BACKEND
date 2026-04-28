package com.Twoeye.fincore_backend.application.account;

import com.Twoeye.fincore_backend.application.account.command.CreateAccountCommand;
import com.Twoeye.fincore_backend.domain.account.Account;
import com.Twoeye.fincore_backend.domain.account.AccountRepository;
import com.Twoeye.fincore_backend.domain.account.exception.AccountNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
@Transactional
public class AccountCommandService {

    private final AccountRepository accountRepository;

    public Account createAccount(CreateAccountCommand command) {
        String accountNumber = generateUniqueAccountNumber();

        Account.AccountBuilder builder = Account.builder()
                .userId(command.userId())
                .productId(command.productId())
                .accountNumber(accountNumber);

        if (command.dailyTransferLimit() != null) {
            builder.dailyTransferAmount(command.dailyTransferLimit());
        }

        return accountRepository.save(builder.build());
    }

    public void closeAccount(String accountId) {
        Account account = findAccountOrThrow(accountId);
        account.close();
        accountRepository.save(account);
    }

    public void dormantAccount(String accountId) {
        Account account = findAccountOrThrow(accountId);
        account.dormant();
        accountRepository.save(account);
    }

    public Account deposit(String accountId, BigDecimal amount) {
        Account account = findAccountOrThrow(accountId);
        account.deposit(amount);
        return accountRepository.save(account);
    }

    public Account withdraw(String accountId, BigDecimal amount) {
        Account account = findAccountOrThrow(accountId);
        account.withdraw(amount);
        return accountRepository.save(account);
    }

    private Account findAccountOrThrow(String accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new AccountNotFoundException(accountId));
    }

    private String generateUniqueAccountNumber() {
        String accountNumber;
        do {
            long number = ThreadLocalRandom.current().nextLong(1_000_0000L, 9_999_9999L);
            accountNumber = "110-" + number;
        } while (accountRepository.existsByAccountNumber(accountNumber));
        return accountNumber;
    }
}
