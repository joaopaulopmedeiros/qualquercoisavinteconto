package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.dto.CategoryDTO;
import com.github.qualquercoisavinteconto.models.Category;
import com.github.qualquercoisavinteconto.services.CategoryService;

import org.springframework.web.bind.annotation.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

@RestController
@Tag(name = "Categories")
@RequestMapping("/categories")
public class CategoryController {
    @Autowired
    CategoryService service;

    @GetMapping
    public List<Category> findAll() {
        return this.service.findAll();
    }

    @GetMapping("{id}")
    public Category findById(@PathVariable Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Category save(@RequestBody CategoryDTO category) {
        System.out.println(category.getName());
        Category newCategory = new Category();
        newCategory.setName(category.getName());
        return this.service.save(newCategory);
    }
    
    @PutMapping("{id}")
    public void update(@PathVariable Long id, @RequestBody CategoryDTO categoryDTO) {
        this.service.update(id, categoryDTO);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
