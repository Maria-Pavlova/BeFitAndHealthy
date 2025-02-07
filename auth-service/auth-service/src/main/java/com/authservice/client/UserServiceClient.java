package com.authservice.client;

import com.authservice.dto.RegisterRequest;
import com.authservice.dto.UserResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "user-service", url = "http://localhost:8080", path = "api/v1/users")
public interface UserServiceClient {

    @PostMapping("/register")
    ResponseEntity<UserResponse> registerUser(@RequestBody RegisterRequest request);

    @GetMapping("/{email}")
    ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email);
}
