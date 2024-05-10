package com.github.qualquercoisavinteconto.services.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.github.qualquercoisavinteconto.dto.ReviewDTO;
import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.models.Review;
import com.github.qualquercoisavinteconto.models.User;
import com.github.qualquercoisavinteconto.repositories.ReviewRepository;
import com.github.qualquercoisavinteconto.services.ProductService;
import com.github.qualquercoisavinteconto.services.ReviewService;
import com.github.qualquercoisavinteconto.services.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService{
  
  private final ReviewRepository reviewRepository;
  private final ProductService productService;
  private final UserService userService;

  @Override
  public Review save(ReviewDTO reviewDTO) {
    Product product = productService.findById(reviewDTO.getProduct_id());
    User user = userService.findById(reviewDTO.getUser_id());
    Review review = new Review();
    review.setDescription(reviewDTO.getDescription());
    review.setStars(reviewDTO.getStars());
    review.setProduct(product);
    review.setUser(user);
    return reviewRepository.save(review);
  }

  @Override
  public Review findById(Long id) {
    return reviewRepository.findById(id).orElseThrow(() -> new RuntimeException("Review not found"));
  }

  @Override
  public List<Review> findAll() {
    return reviewRepository.findAll();
  }

  @Override
  public List<Review> findByProductId(Long id) {
    return reviewRepository.findByProduct_id(id);
  }

  @Override
  public List<Review> findByUserId(Long id) {
    return reviewRepository.findByUser_id(id);
  }

  @Override
  public void delete(Long id) {
    reviewRepository.deleteById(id);
  }

}