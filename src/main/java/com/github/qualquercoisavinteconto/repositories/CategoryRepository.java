package com.github.qualquercoisavinteconto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{
  
}
