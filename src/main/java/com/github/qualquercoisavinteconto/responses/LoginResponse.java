package com.github.qualquercoisavinteconto.responses;

import lombok.Data;

@Data
public class LoginResponse 
{
    private String accessToken;
    private String expiresIn;
}
