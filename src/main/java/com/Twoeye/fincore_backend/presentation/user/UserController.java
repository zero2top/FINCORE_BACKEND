package com.Twoeye.fincore_backend.presentation.user;

import com.Twoeye.fincore_backend.application.user.UserCommandService;
import com.Twoeye.fincore_backend.application.user.UserQueryService;
import com.Twoeye.fincore_backend.presentation.common.ApiResponse;
import com.Twoeye.fincore_backend.presentation.user.dto.RegisterUserRequest;
import com.Twoeye.fincore_backend.presentation.user.dto.UserResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserCommandService userCommandService;
    private final UserQueryService userQueryService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ApiResponse<UserResponse> register(@RequestBody @Valid RegisterUserRequest request) {
        return ApiResponse.ok(UserResponse.from(userCommandService.register(request.toCommand())));
    }

    @GetMapping("/{userId}")
    public ApiResponse<UserResponse> getUser(@PathVariable String userId) {
        return ApiResponse.ok(UserResponse.from(userQueryService.getUser(userId)));
    }
}
