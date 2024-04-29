package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.requests.ProductSearchRequest;
import com.github.qualquercoisavinteconto.responses.ProductSearchResponse;
import com.github.qualquercoisavinteconto.services.ProductService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("products")
public class ProductController 
{
    private final ProductService service;

    public ProductController(ProductService service)
    {
        this.service = service;
    }

    @GetMapping
    public List<ProductSearchResponse> search(ProductSearchRequest request) 
    {
        return this.service.search(request);
    }
}
