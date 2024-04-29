package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("hello")
public class HelloController 
{
    @GetMapping
    public String say() 
    {
        return "hello!";
    }
}
