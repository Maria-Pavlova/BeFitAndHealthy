package com.userservice.service;

import com.userservice.dto.RegisterRequest;
import com.userservice.dto.UserResponse;
import com.userservice.model.User;
import com.userservice.model.UserStatus;
import com.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse register(RegisterRequest request) {
        User user = User.builder()
                .id(UUID.randomUUID())
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .password(request.password())
                .gender(request.gender())
                .age(request.age())
                .role(request.role())
                .status(UserStatus.ACTIVE)
                .build();
        userRepository.save(user);
        log.info("Successfully registered user");
        return new UserResponse(user.getId().toString(), user.getFirstName(), user.getLastName(),
                user.getEmail(), user.getAge(), user.getGender(), user.getRole(), user.getStatus());
    }

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(user.getId().toString(), user.getFirstName(), user.getLastName(),
                        user.getEmail(), user.getAge(), user.getGender(), user.getRole(), user.getStatus()))
                .toList();
    }
}
