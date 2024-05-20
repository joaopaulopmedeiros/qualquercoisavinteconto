package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.models.Category;
import com.github.qualquercoisavinteconto.requests.CategoryRequest;

public interface CategoryService {

  Category save(Category category);
  Category findById(Long id);
  List<Category> findByName(String name);
  List<Category> findAll();
  void delete(Long id);
  void update(Long id, CategoryRequest categoryDTO);
  
}
