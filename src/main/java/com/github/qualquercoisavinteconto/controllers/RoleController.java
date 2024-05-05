package com.github.qualquercoisavinteconto.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.qualquercoisavinteconto.models.Role;
import com.github.qualquercoisavinteconto.requests.RoleSearchRequest;
import com.github.qualquercoisavinteconto.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;



@Tag(name = "Roles")
@RequestMapping("roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }
}
