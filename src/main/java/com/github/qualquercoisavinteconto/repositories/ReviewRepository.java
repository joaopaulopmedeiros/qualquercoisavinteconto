package com.github.qualquercoisavinteconto.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
  
  Optional<Review> findByProduct_id(Long id);
  Optional<Review> findByUser_id(Long id);

}
