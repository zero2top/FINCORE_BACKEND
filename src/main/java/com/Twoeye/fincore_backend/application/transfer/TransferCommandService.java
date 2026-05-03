package com.Twoeye.fincore_backend.application.transfer;

import com.Twoeye.fincore_backend.application.transfer.command.TransferCommand;
import com.Twoeye.fincore_backend.domain.account.Account;
import com.Twoeye.fincore_backend.domain.account.AccountRepository;
import com.Twoeye.fincore_backend.domain.account.exception.AccountNotFoundException;
import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import com.Twoeye.fincore_backend.domain.transaction.TransactionRepository;
import com.Twoeye.fincore_backend.domain.transaction.TransactionType;
import com.Twoeye.fincore_backend.domain.transfer.Transfer;
import com.Twoeye.fincore_backend.domain.transfer.TransferRepository;
import com.Twoeye.fincore_backend.domain.transfer.exception.DuplicateTransferException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Transactional
public class TransferCommandService {

    private final TransferRepository transferRepository;
    private final AccountRepository accountRepository;
    private final TransactionRepository transactionRepository;

    public Transfer transfer(TransferCommand command) {
        if (transferRepository.findByIdempotencyKey(command.idempotencyKey()).isPresent()) {
            throw new DuplicateTransferException(command.idempotencyKey());
        }

        Transfer transfer = transferRepository.save(Transfer.builder()
                .fromAccountId(command.fromAccountId())
                .toAccountNumber(command.toAccountNumber())
                .amount(command.amount())
                .idempotencyKey(command.idempotencyKey())
                .build());

        Account fromAccount = accountRepository.findById(command.fromAccountId())
                .orElseThrow(() -> new AccountNotFoundException(command.fromAccountId()));
        Account toAccount = accountRepository.findByAccountNumber(command.toAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException(command.toAccountNumber()));

        fromAccount.withdraw(command.amount());
        toAccount.deposit(command.amount());
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

        transfer.complete(LocalDateTime.now());
        transferRepository.save(transfer);

        transactionRepository.save(Transaction.builder()
                .accountId(fromAccount.getAccountId())
                .transferId(transfer.getTransferId())
                .type(TransactionType.TRANSFER)
                .amount(command.amount())
                .balanceAfter(fromAccount.getBalance())
                .counterparty(toAccount.getAccountNumber())
                .build());

        transactionRepository.save(Transaction.builder()
                .accountId(toAccount.getAccountId())
                .transferId(transfer.getTransferId())
                .type(TransactionType.DEPOSIT)
                .amount(command.amount())
                .balanceAfter(toAccount.getBalance())
                .counterparty(fromAccount.getAccountNumber())
                .build());

        return transfer;
    }
}
