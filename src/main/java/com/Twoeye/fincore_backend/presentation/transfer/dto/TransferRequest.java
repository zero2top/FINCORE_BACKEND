package com.Twoeye.fincore_backend.presentation.transfer.dto;

import com.Twoeye.fincore_backend.application.transfer.command.TransferCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record TransferRequest(
        @NotBlank(message = "출금 계좌 ID는 필수입니다.")
        String fromAccountId,

        @NotBlank(message = "입금 계좌번호는 필수입니다.")
        String toAccountNumber,

        @Positive(message = "이체 금액은 양수여야 합니다.")
        BigDecimal amount,

        @NotBlank(message = "멱등성 키는 필수입니다.")
        String idempotencyKey
) {
    public TransferCommand toCommand() {
        return new TransferCommand(fromAccountId, toAccountNumber, amount, idempotencyKey);
    }
}
