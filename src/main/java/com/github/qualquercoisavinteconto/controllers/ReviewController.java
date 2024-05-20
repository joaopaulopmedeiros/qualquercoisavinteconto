package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.services.impl.ReviewServiceImpl;
import com.github.qualquercoisavinteconto.models.Review;
import com.github.qualquercoisavinteconto.dto.ReviewDTO;
import com.github.qualquercoisavinteconto.exceptions.ResourceNotFoundException;

@RestController
@Tag(name = "Review")
@RequestMapping("reviews")
public class ReviewController {

    private final ReviewServiceImpl reviewService;

    public ReviewController(ReviewServiceImpl reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review save(@RequestBody ReviewDTO reviewDTO) {
        ReviewDTO review = new ReviewDTO();
        review.setDescription(reviewDTO.getDescription());
        review.setStars(reviewDTO.getStars());
        review.setUserId(reviewDTO.getUserId());
        review.setProductId(reviewDTO.getProductId());
        return reviewService.save(review);
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getReviewById(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        if(review == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
        }
        return ResponseEntity.ok(review);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<?> getReviewByUser(@PathVariable Long id) {
        List<Review> reviews = reviewService.findByUserId(id);
        if(reviews.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Address not found");
        }
        return ResponseEntity.ok(reviews);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<?> deleterEVIEW(@PathVariable Long id) {
        Review review = reviewService.findById(id);
        if(review == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Review not found");
        }
        reviewService.delete(id);
        return ResponseEntity.ok("Review deleted");
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable Long id, @RequestBody ReviewDTO reviewDTO) throws ResourceNotFoundException {
        reviewService.update(id, reviewDTO);
        return ResponseEntity.noContent().build();
    }

}