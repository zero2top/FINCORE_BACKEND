package com.Twoeye.fincore_backend.presentation.subscription;

import com.Twoeye.fincore_backend.application.subscription.SubscriptionCommandService;
import com.Twoeye.fincore_backend.application.subscription.SubscriptionQueryService;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import com.Twoeye.fincore_backend.presentation.subscription.dto.SubscribeRequest;
import com.Twoeye.fincore_backend.presentation.subscription.dto.SubscriptionResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subscriptions")
@RequiredArgsConstructor
public class SubscriptionController {

    private final SubscriptionCommandService subscriptionCommandService;
    private final SubscriptionQueryService subscriptionQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<SubscriptionResponse> subscribe(@RequestBody @Valid SubscribeRequest request) {
        return ApiResponse.ok(SubscriptionResponse.from(subscriptionCommandService.subscribe(request.toCommand())));
    }

    @GetMapping("/{subscriptionId}")
    public ApiResponse<SubscriptionResponse> getSubscription(@PathVariable String subscriptionId) {
        return ApiResponse.ok(SubscriptionResponse.from(subscriptionQueryService.getSubscription(subscriptionId)));
    }

    @GetMapping("/user/{userId}")
    public ApiResponse<List<SubscriptionResponse>> getSubscriptionsByUser(@PathVariable String userId) {
        return ApiResponse.ok(subscriptionQueryService.getSubscriptionsByUserId(userId).stream()
                .map(SubscriptionResponse::from)
                .toList());
    }

    @GetMapping("/account/{accountId}")
    public ApiResponse<List<SubscriptionResponse>> getSubscriptionsByAccount(@PathVariable String accountId) {
        return ApiResponse.ok(subscriptionQueryService.getSubscriptionsByAccountId(accountId).stream()
                .map(SubscriptionResponse::from)
                .toList());
    }

    @PatchMapping("/{subscriptionId}/cancel")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void cancel(@PathVariable String subscriptionId) {
        subscriptionCommandService.cancel(subscriptionId);
    }
}
