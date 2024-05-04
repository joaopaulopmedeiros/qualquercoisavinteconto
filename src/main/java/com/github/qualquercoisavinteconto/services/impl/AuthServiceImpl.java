package com.github.qualquercoisavinteconto.services.impl;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.requests.LoginRequest;
import com.github.qualquercoisavinteconto.responses.LoginResponse;
import com.github.qualquercoisavinteconto.services.AuthService;
import com.github.qualquercoisavinteconto.services.TokenService;

@Service
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authManager;
    private final TokenService tokenService;

    public AuthServiceImpl(
            AuthenticationManager authManager,
            TokenService tokenService) {
        this.authManager = authManager;
        this.tokenService = tokenService;
    }

    @Override
    public LoginResponse login(LoginRequest request) {
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword());

        Authentication authentication = this.authManager
                .authenticate(usernamePasswordAuthenticationToken);

        var user = (User) authentication.getPrincipal();

        String token = tokenService.createToken(user);

        return LoginResponse.builder()
                .accessToken(token)
                .build();
    }
}
