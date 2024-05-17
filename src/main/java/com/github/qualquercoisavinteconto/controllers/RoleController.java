package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@Tag(name = "Roles")
@RequestMapping("roles")
public class RoleController {
    private final RoleService service;

    public RoleController(RoleService service) {
        this.service = service;
    }
}
