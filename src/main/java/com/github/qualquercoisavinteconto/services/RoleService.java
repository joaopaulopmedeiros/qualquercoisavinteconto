package com.github.qualquercoisavinteconto.services;

import java.util.List;
import java.util.Optional;

import com.github.qualquercoisavinteconto.models.Role;

public interface RoleService {

  Role save(Role role);
  Role findById(Long id);
  Role findByName(String name);
  List<Role> findAll();
  void delete(Long id);
  
}
