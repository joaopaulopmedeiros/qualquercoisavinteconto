package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.models.Category;

public interface CategoryService {

  Category save(Category category);
  Category findById(Long id);
  List<Category> findByName(String name);
  List<Category> findAll();
  void delete(Long id);
  
}
