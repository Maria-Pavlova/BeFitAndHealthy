package com.userservice.dto;

import com.userservice.model.Gender;
import com.userservice.model.Role;


public record RegisterRequest(String firstName, String lastName, String email, Integer age, Gender gender,
                              String password, Role role) {
}
