package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@Tag(name = "Users")
@RequestMapping("users")
public class UserController {
    @GetMapping
    public String get(@RequestParam String param) {
        return new String();
    }
}
