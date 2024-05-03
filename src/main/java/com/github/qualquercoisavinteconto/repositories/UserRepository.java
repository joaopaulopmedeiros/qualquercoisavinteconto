package com.github.qualquercoisavinteconto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.User;

public interface UserRepository extends JpaRepository<User, Long> 
{    

    Optional<User> findByEmail(String email);

    // Recupera os usuários cujo nome contenha a string passada como parâmetro
    List<User> findByNameContainingIgnoreCase(String name);

}
