package com.github.qualquercoisavinteconto.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.models.Role;
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

    @GetMapping
    public ResponseEntity<List<Role>> search() {
        var result = this.service.findAll();
        if (result == null || result.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }
}
