package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.responses.UserSearchResponse;
import com.github.qualquercoisavinteconto.services.UserService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@Tag(name = "Users")
@RequestMapping("users")
public class UserController {

    private final UserService service;

    public UserController(UserService service)
    {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<UserSearchResponse>> search() {
        var result = this.service.findAll();
        if (result == null || result.isEmpty()) return ResponseEntity.noContent().build();
        return ResponseEntity.ok(result);
    }
}
