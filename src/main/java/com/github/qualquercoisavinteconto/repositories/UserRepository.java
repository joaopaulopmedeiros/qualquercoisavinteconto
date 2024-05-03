package com.github.qualquercoisavinteconto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.User;

public interface UserRepository extends JpaRepository<User, Long> 
{    
}
