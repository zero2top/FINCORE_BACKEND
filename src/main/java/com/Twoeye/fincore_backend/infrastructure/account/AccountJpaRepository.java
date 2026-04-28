package com.Twoeye.fincore_backend.infrastructure.account;

import com.Twoeye.fincore_backend.domain.account.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

interface AccountJpaRepository extends JpaRepository<Account, String> {

    Optional<Account> findByAccountNumber(String accountNumber);

    List<Account> findAllByUserId(String userId);

    boolean existsByAccountNumber(String accountNumber);
}