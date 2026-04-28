package com.Twoeye.fincore_backend.infrastructure.account;

import com.Twoeye.fincore_backend.domain.account.Account;
import com.Twoeye.fincore_backend.domain.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class AccountRepositoryImpl implements AccountRepository {

    private final AccountJpaRepository jpaRepository;

    @Override
    public Account save(Account account) {
        return jpaRepository.save(account);
    }

    @Override
    public Optional<Account> findById(String accountId) {
        return jpaRepository.findById(accountId);
    }

    @Override
    public Optional<Account> findByAccountNumber(String accountNumber) {
        return jpaRepository.findByAccountNumber(accountNumber);
    }

    @Override
    public List<Account> findAllByUserId(String userId) {
        return jpaRepository.findAllByUserId(userId);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return jpaRepository.existsByAccountNumber(accountNumber);
    }
}
