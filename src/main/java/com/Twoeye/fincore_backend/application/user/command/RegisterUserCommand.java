package com.Twoeye.fincore_backend.application.user.command;

public record RegisterUserCommand(
        String loginId,
        String password,
        String name,
        String phoneNumber,
        String pin
) {
}
