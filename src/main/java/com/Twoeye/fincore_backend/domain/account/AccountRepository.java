package com.Twoeye.fincore_backend.domain.account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {

    Account save(Account account);

    Optional<Account> findById(String accountId);

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findAllByUserId(String userId);

    boolean existsByAccountNumber(String accountNumber);
}
