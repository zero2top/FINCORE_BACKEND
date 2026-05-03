package com.Twoeye.fincore_backend.application.user;

import com.Twoeye.fincore_backend.application.user.command.RegisterUserCommand;
import com.Twoeye.fincore_backend.domain.user.User;
import com.Twoeye.fincore_backend.domain.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserCommandService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public User register(RegisterUserCommand command) {
        if (userRepository.existsByLoginId(command.loginId())) {
            throw new IllegalArgumentException("이미 사용 중인 아이디입니다.");
        }
        if (userRepository.existsByPhoneNumber(command.phoneNumber())) {
            throw new IllegalArgumentException("이미 등록된 전화번호입니다.");
        }

        User user = User.builder()
                .loginId(command.loginId())
                .password(passwordEncoder.encode(command.password()))
                .name(command.name())
                .phoneNumber(command.phoneNumber())
                .pin(passwordEncoder.encode(command.pin()))
                .build();

        return userRepository.save(user);
    }
}
