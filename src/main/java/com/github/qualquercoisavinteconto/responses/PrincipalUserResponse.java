package com.github.qualquercoisavinteconto.responses;

import java.util.List;

import com.github.qualquercoisavinteconto.models.Role;

import lombok.Data;

@Data
public class PrincipalUserResponse {
    private Long id;
    private String name;
    private List<Role> roles;   
}
