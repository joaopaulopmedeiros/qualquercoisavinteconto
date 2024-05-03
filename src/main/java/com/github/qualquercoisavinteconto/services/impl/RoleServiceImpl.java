package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.models.Role;
import com.github.qualquercoisavinteconto.repositories.RoleRepository;
import com.github.qualquercoisavinteconto.services.RoleService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
  
  private final RoleRepository roleRepository;

  @Override
  public Role save(Role role) {
    return roleRepository.save(role);
  }

  @Override
  public Role findById(Long id) {
    return roleRepository.findById(id).orElse(null);
  }

  @Override
  public Role findByName(String name) {
    return roleRepository.findByNameContainingIgnoreCase(name).orElse(null);
  }

  @Override
  public List<Role> findAll() {
    return roleRepository.findAll();
  }

  @Override
  public void delete(Long id) {
    roleRepository.deleteById(id);
  }
}
