package com.Twoeye.fincore_backend.presentation.account.dto;

import com.Twoeye.fincore_backend.application.account.command.CreateAccountCommand;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record CreateAccountRequest(
        @NotBlank(message = "userId는 필수입니다.")
        String userId,

        @NotBlank(message = "productId는 필수입니다.")
        String productId,

        @Positive(message = "일일 이체 한도는 양수여야 합니다.")
        BigDecimal dailyTransferLimit
) {
    public CreateAccountCommand toCommand() {
        return new CreateAccountCommand(userId, productId, dailyTransferLimit);
    }
}
