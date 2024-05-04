package com.github.qualquercoisavinteconto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.github.qualquercoisavinteconto.models.User;

public interface UserRepository extends JpaRepository<User, Long> {

    UserDetails findUserDetailsByEmail(String email);

    Optional<User> findByEmail(String email);

    List<User> findByNameContainingIgnoreCase(String name);

}
