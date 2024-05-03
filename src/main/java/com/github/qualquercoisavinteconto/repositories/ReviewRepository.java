package com.github.qualquercoisavinteconto.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
  
}
