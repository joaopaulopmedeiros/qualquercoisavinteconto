package com.github.qualquercoisavinteconto.services;

import com.github.qualquercoisavinteconto.requests.LoginRequest;
import com.github.qualquercoisavinteconto.responses.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest request);
}
