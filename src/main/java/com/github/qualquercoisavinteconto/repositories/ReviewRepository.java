package com.github.qualquercoisavinteconto.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.qualquercoisavinteconto.models.Review;

public interface ReviewRepository extends JpaRepository<Review, Long>{
  
  List<Review> findByProduct_id(Long id);
  List<Review> findByUser_id(Long id);

}
