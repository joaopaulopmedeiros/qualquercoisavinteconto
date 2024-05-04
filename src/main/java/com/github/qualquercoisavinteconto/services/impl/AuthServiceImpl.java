package com.github.qualquercoisavinteconto.services.impl;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.requests.LoginRequest;
import com.github.qualquercoisavinteconto.responses.LoginResponse;
import com.github.qualquercoisavinteconto.services.AuthService;

@Service
public class AuthServiceImpl implements AuthService 
{
    @Override
    public LoginResponse login(LoginRequest request) 
    {
        var response = new LoginResponse();
        response.setAccessToken("token");
        response.setExpiresIn("3600");
        return response;
    }
}
