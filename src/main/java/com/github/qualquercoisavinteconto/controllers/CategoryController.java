package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("categories")
public class CategoryController {
    @GetMapping()
    public String get() {
        return "Hi";
    }
}
