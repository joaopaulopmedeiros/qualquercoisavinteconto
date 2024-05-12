package com.github.qualquercoisavinteconto.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.dto.ProductDTO;
import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.requests.ProductSearchRequest;
import com.github.qualquercoisavinteconto.responses.ProductSearchResponse;
import com.github.qualquercoisavinteconto.services.ProductService;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@Tag(name = "Products")
@RequestMapping("products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public List<ProductSearchResponse> search(ProductSearchRequest request) {
        return this.service.search(request);
    }

    @GetMapping("/id")
    public Product findById(Long id) {
        return this.service.findById(id);
    }

    @PostMapping
    public Product save(ProductDTO product) {
        System.out.println(product.getName() + product.getPrice());
        return this.service.save(product);
    }

    @PutMapping("/id")
    public void update(@PathVariable Long id, ProductDTO productDTO) {
        this.service.update(id, productDTO);
    }

    @DeleteMapping("/id")
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }
}
