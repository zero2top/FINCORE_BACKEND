package com.Twoeye.fincore_backend.presentation.account;

import com.Twoeye.fincore_backend.application.account.AccountCommandService;
import com.Twoeye.fincore_backend.application.account.AccountQueryService;
import com.Twoeye.fincore_backend.domain.account.Account;
import com.Twoeye.fincore_backend.presentation.account.dto.AccountResponse;
import com.Twoeye.fincore_backend.presentation.account.dto.CreateAccountRequest;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountCommandService accountCommandService;
    private final AccountQueryService accountQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<AccountResponse> createAccount(@RequestBody @Valid CreateAccountRequest request) {
        Account account = accountCommandService.createAccount(request.toCommand());
        return ApiResponse.ok(AccountResponse.from(account));
    }

    @GetMapping("/{accountId}")
    public ApiResponse<AccountResponse> getAccount(@PathVariable String accountId) {
        Account account = accountQueryService.getAccount(accountId);
        return ApiResponse.ok(AccountResponse.from(account));
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<AccountResponse>> getAccountsByUser(@PathVariable String userId) {
        List<AccountResponse> accounts = accountQueryService.getAccountsByUserId(userId).stream()
                .map(AccountResponse::from)
                .toList();
        return ApiResponse.ok(accounts);
    }

    @PatchMapping("/{accountId}/close")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void closeAccount(@PathVariable String accountId) {
        accountCommandService.closeAccount(accountId);
    }

    @PatchMapping("/{accountId}/dormant")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void dormantAccount(@PathVariable String accountId) {
        accountCommandService.dormantAccount(accountId);
    }
}
