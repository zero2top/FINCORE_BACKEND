package com.Twoeye.fincore_backend.application.transaction;

import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import com.Twoeye.fincore_backend.domain.transaction.TransactionRepository;
import com.Twoeye.fincore_backend.domain.transaction.exception.TransactionNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TransactionQueryService {

    private final TransactionRepository transactionRepository;

    public Transaction getTransaction(String transactionId) {
        return transactionRepository.findById(transactionId)
                .orElseThrow(() -> new TransactionNotFoundException(transactionId));
    }

    // size+1개 조회 → hasNext 판별은 컨트롤러/서비스에서
    public List<Transaction> getTransactionsByAccountId(String accountId, LocalDateTime cursor, int size) {
        return transactionRepository.findAllByAccountId(accountId, cursor, size + 1);
    }

    public List<Transaction> getTransactionsByTransferId(String transferId) {
        return transactionRepository.findAllByTransferId(transferId);
    }
}
