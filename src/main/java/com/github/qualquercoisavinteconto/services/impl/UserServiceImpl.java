package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.repositories.UserRepository;
import com.github.qualquercoisavinteconto.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
  
  private final UserRepository userRepository;

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public User findById(Long id) {
    return userRepository.findById(id).orElse(null);
  }

  @Override
  public User findByEmail(String email) {
    return userRepository.findByEmail(email).orElse(null);
  }

  // Recupera os usuários cujo nome contenha a string passada como parâmetro
  @Override
  public List<User> findByName(String name) {
    return userRepository.findByNameContainingIgnoreCase(name);
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public void delete(Long id) {
    userRepository.deleteById(id);
  }
}
