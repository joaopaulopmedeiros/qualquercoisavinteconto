package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.dto.ReviewDTO;
import com.github.qualquercoisavinteconto.models.Review;

public interface ReviewService {
  
  Review save(Review reviewDTO);
  Review findById(Long id);
  List<Review> findAll();
  List<Review> findByProductId(Long id);
  List<Review> findByUserId(Long id);
  void delete(Long id);

}
