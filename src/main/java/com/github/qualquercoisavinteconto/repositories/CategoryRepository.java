package com.github.qualquercoisavinteconto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

  List<Category> findByNameContainingIgnoreCase(String name);
  
}
