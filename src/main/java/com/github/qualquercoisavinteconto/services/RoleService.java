package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.exceptions.ResourceNotFoundException;
import com.github.qualquercoisavinteconto.models.Role;
import com.github.qualquercoisavinteconto.requests.RoleStoreRequest;

public interface RoleService {

  Role save(RoleStoreRequest role);
  Role findById(Long id) throws ResourceNotFoundException;
  Role findByName(String name);
  List<Role> findAll();
  void delete(Long id);
  
}
