package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Categories")
@RequestMapping("categories")
public class CategoryController {
    @GetMapping()
    public String get() {
        return "Hi";
    }
}
