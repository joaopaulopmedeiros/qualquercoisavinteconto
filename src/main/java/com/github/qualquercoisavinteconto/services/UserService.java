package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.models.User;

public interface UserService {

  User save(User user);
  User findById(Long id);
  User findByEmail(String email);
  List<User> findByName(String name);
  List<User> findAll();
  void delete(Long id);
  
}
