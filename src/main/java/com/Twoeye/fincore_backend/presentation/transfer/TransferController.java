package com.Twoeye.fincore_backend.presentation.transfer;

import com.Twoeye.fincore_backend.application.transfer.TransferCommandService;
import com.Twoeye.fincore_backend.application.transfer.TransferQueryService;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import com.Twoeye.fincore_backend.presentation.transfer.dto.TransferRequest;
import com.Twoeye.fincore_backend.presentation.transfer.dto.TransferResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/transfers")
@RequiredArgsConstructor
public class TransferController {

    private final TransferCommandService transferCommandService;
    private final TransferQueryService transferQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<TransferResponse> transfer(@RequestBody @Valid TransferRequest request) {
        return ApiResponse.ok(TransferResponse.from(transferCommandService.transfer(request.toCommand())));
    }

    @GetMapping("/{transferId}")
    public ApiResponse<TransferResponse> getTransfer(@PathVariable String transferId) {
        return ApiResponse.ok(TransferResponse.from(transferQueryService.getTransfer(transferId)));
    }

    @GetMapping("/account/{accountId}")
    public ApiResponse<List<TransferResponse>> getTransfersByAccount(@PathVariable String accountId) {
        return ApiResponse.ok(transferQueryService.getTransfersByFromAccountId(accountId).stream()
                .map(TransferResponse::from)
                .toList());
    }
}
