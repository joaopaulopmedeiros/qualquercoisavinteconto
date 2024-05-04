package com.github.qualquercoisavinteconto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> 
{    

  Optional<Role> findByNameContainingIgnoreCase(String name);

}
