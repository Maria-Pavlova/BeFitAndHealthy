package com.authservice.dto;

import com.authservice.enums.Gender;
import com.authservice.enums.Role;
import com.authservice.enums.UserStatus;
import lombok.Data;

import java.util.UUID;

@Data
public class UserResponse {
    private UUID id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Gender gender;
    private Integer age;
    private Role role;
    private UserStatus status;
}
