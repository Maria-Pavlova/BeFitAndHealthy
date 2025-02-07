package com.userservice.service;

import com.userservice.dto.RegisterRequest;
import com.userservice.dto.UserResponse;
import com.userservice.exception.UserNotFoundException;
import com.userservice.model.User;
import com.userservice.model.UserStatus;
import com.userservice.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(passwordEncoder.encode(request.password()))
                .gender(request.gender())
                .age(request.age())
                .role(request.role())
                .status(UserStatus.ACTIVE)
                .build();
        userRepository.save(user);
        log.info("Successfully registered user with id {}", user.getId());
        return mapToUserResponse(user);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(this::mapToUserResponse).toList();
    }

    public UserResponse getByEmail(String email) {
        Optional<User> user = userRepository.findByEmail(email);
        if (user.isEmpty())
            throw new UserNotFoundException("User not found");
        return mapToUserResponse(user.get());
    }

    private UserResponse mapToUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId().toString())
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .age(user.getAge())
                .gender(user.getGender())
                .role(user.getRole())
                .status(user.getStatus())
                .build();
    }


}
