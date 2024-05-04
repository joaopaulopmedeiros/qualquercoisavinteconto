package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.requests.LoginRequest;
import com.github.qualquercoisavinteconto.responses.LoginResponse;
import com.github.qualquercoisavinteconto.services.AuthService;

@RestController
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        return this.service.login(request);
    }
}
