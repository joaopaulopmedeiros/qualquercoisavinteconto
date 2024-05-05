package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.github.qualquercoisavinteconto.services.ProductService;

@RestController
@Tag(name = "Adress")
@RequestMapping("adress")
public class AdessController {
    private final ProductService service;

    public AdessController(ProductService service) {
        this.service = service;
    }
}