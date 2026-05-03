package com.Twoeye.fincore_backend.presentation.transaction;

import com.Twoeye.fincore_backend.application.transaction.TransactionQueryService;
import com.Twoeye.fincore_backend.domain.transaction.Transaction;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import com.Twoeye.fincore_backend.presentation.common.CursorPageResponse;
import com.Twoeye.fincore_backend.presentation.transaction.dto.TransactionResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionQueryService transactionQueryService;

    @GetMapping("/{transactionId}")
    public ApiResponse<TransactionResponse> getTransaction(@PathVariable String transactionId) {
        return ApiResponse.ok(TransactionResponse.from(transactionQueryService.getTransaction(transactionId)));
    }

    @GetMapping("/account/{accountId}")
    public ApiResponse<CursorPageResponse<TransactionResponse>> getTransactionsByAccount(
            @PathVariable String accountId,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime cursor,
            @RequestParam(defaultValue = "20") int size) {

        List<Transaction> result = transactionQueryService.getTransactionsByAccountId(accountId, cursor, size);

        boolean hasNext = result.size() > size;
        List<TransactionResponse> content = result.stream()
                .limit(size)
                .map(TransactionResponse::from)
                .toList();

        String nextCursor = hasNext ? content.get(content.size() - 1).createdAt().toString() : null;

        return ApiResponse.ok(CursorPageResponse.of(content, nextCursor, hasNext, size));
    }

    @GetMapping("/transfer/{transferId}")
    public ApiResponse<List<TransactionResponse>> getTransactionsByTransfer(@PathVariable String transferId) {
        return ApiResponse.ok(transactionQueryService.getTransactionsByTransferId(transferId).stream()
                .map(TransactionResponse::from)
                .toList());
    }
}
