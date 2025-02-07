package com.authservice.service;


import com.authservice.client.UserServiceClient;
import com.authservice.dto.AuthenticationRequest;
import com.authservice.dto.AuthenticationResponse;
import com.authservice.dto.RegisterRequest;
import com.authservice.dto.UserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserServiceClient userServiceClient;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public UserResponse register(RegisterRequest request) {
        return userServiceClient.registerUser(request).getBody();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {

        UserResponse user = userServiceClient.getUserByEmail(request.getEmail()).getBody();
        if (!user.getEmail().equals(request.getEmail())){
           throw new UsernameNotFoundException("User not found");
        }
        UsernamePasswordAuthenticationToken token =
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());
        authenticationManager.authenticate(token);
        return AuthenticationResponse.builder()
                .token(jwtService.generateToken(request.getEmail()))
                .build();

    }
}
