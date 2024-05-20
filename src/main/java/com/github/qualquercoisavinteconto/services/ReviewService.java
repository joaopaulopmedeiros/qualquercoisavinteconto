package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.dto.ReviewDTO;
import com.github.qualquercoisavinteconto.exceptions.ResourceNotFoundException;
import com.github.qualquercoisavinteconto.models.Review;

public interface ReviewService {
  
  Review save(ReviewDTO reviewDTO) throws ResourceNotFoundException;
  Review findById(Long id);
  List<Review> findAll();
  List<Review> findByProductId(Long id);
  List<Review> findByUserId(Long id);
  void delete(Long id);
  Review update(Long id, ReviewDTO reviewDTO) throws ResourceNotFoundException;

}
