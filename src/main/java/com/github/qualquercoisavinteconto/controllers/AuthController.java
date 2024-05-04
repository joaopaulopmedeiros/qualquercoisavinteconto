package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.requests.SigninRequest;
import com.github.qualquercoisavinteconto.requests.SignupRequest;
import com.github.qualquercoisavinteconto.responses.SigninResponse;
import com.github.qualquercoisavinteconto.responses.SignupResponse;
import com.github.qualquercoisavinteconto.services.AuthService;

@RestController
public class AuthController {
    private final AuthService service;

    public AuthController(AuthService service) {
        this.service = service;
    }

    @PostMapping("/signin")
    public SigninResponse signin(@RequestBody SigninRequest request) {
        return this.service.signin(request);
    }

    @PostMapping("/signup")
    public SignupResponse signup(@RequestBody SignupRequest request) {
        return this.service.signup(request);
    }
}
