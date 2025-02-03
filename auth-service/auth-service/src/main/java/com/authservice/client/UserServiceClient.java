package com.authservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "user-service", path = "/v1/users")
public interface UserServiceClient {

    @PostMapping("/register")
    ResponseEntity<RegisterRequest>
}
