package com.authservice.service;

import com.authservice.client.UserServiceClient;
import com.authservice.dto.UserResponse;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserServiceClient userServiceClient;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            UserResponse user = userServiceClient.getUserByEmail(username).getBody();
            return new CustomUserDetails(user);
        }catch (FeignException e) {
            throw new UsernameNotFoundException("User not found", e);
        }
    }
}
