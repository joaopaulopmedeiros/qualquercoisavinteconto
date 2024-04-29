package com.github.qualquercoisavinteconto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Product;

public interface ProductRepository extends JpaRepository<Product, Long> 
{    
}
