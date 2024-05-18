package com.github.qualquercoisavinteconto.services;

import java.util.List;

import com.github.qualquercoisavinteconto.dto.ReviewDTO;
import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.models.Review;
import com.github.qualquercoisavinteconto.requests.ProductRequest;

public interface ReviewService {
  
  Review save(ReviewDTO reviewDTO);
  Review findById(Long id);
  List<Review> findAll();
  List<Review> findByProductId(Long id);
  List<Review> findByUserId(Long id);
  void delete(Long id);
  Review update(Long id, ReviewDTO reviewDTO);

}
