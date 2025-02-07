package com.userservice.dto;

import com.userservice.model.Gender;
import com.userservice.model.Role;
import com.userservice.model.UserStatus;
import lombok.Builder;

@Builder
public record UserResponse(String id,
                           String firstName,
                           String lastName,
                           String email,
                           String password,
                           Integer age,
                           Gender gender,
                           Role role,
                           UserStatus status){
}
