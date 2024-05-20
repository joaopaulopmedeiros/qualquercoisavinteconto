package com.github.qualquercoisavinteconto.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.github.qualquercoisavinteconto.models.Role;
import com.github.qualquercoisavinteconto.requests.RoleStoreRequest;
import com.github.qualquercoisavinteconto.services.RoleService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Tag(name = "Roles")
@RequestMapping("roles")
public class RoleController {
    private final RoleService service;
    private final UriComponentsBuilder uriBuilder;

    public RoleController(RoleService service) {
        this.service = service;
        this.uriBuilder = UriComponentsBuilder.fromUriString("");
    }

    @GetMapping
    public ResponseEntity<List<Role>> search() {
        var result = this.service.findAll();
        if (result == null || result.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<Role> store(@RequestBody RoleStoreRequest request) {
        Role role = this.service.save(request);
        URI location = uriBuilder.path("/roles/{id}").buildAndExpand(role.getId()).toUri();
        return ResponseEntity.created(location).body(role);
    }
}
