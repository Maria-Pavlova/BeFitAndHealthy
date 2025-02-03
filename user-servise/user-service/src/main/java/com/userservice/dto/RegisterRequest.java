package com.userservice.dto;

import com.userservice.model.Gender;
import com.userservice.model.Role;
import jakarta.validation.constraints.*;


public record RegisterRequest(
        @NotBlank(message = "First name is required")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        @Email(message = "Invalid email format")
        @NotBlank(message = "Email is required")
        String email,
        @Size(min = 6, message = "Password must be at least 6 characters long")
        String password,
        @Min(value = 12, message = "Age must be at least 12")
        @Max(value = 100, message = "Age must be at most 100")
        Integer age,
        @NotBlank(message = "Gender is required")
        Gender gender,
        @NotBlank(message = "Role is required")
        Role role) {
}
