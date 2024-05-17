package com.github.qualquercoisavinteconto.controllers;

import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.github.qualquercoisavinteconto.services.ProductService;
import com.github.qualquercoisavinteconto.services.ReviewService;
import com.github.qualquercoisavinteconto.services.UserService;
import com.github.qualquercoisavinteconto.models.Address;
import com.github.qualquercoisavinteconto.models.Review;
import com.github.qualquercoisavinteconto.dto.AddressDTO;
import com.github.qualquercoisavinteconto.dto.ReviewDTO;

@RestController
@Tag(name = "Review")
@RequestMapping("review")
public class ReviewController {
    

    @Autowired
    ReviewService reviewService;

    @Autowired
    UserService userService;

    @Autowired
    ProductService productService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review save(@RequestBody ReviewDTO reviewDTO) {
        ReviewDTO review = new ReviewDTO();
        review.setDescription(reviewDTO.getDescription());
        review.setStars(reviewDTO.getStars());
        review.setUser_id(reviewDTO.getUser_id());
        review.setProduct_id(reviewDTO.getProduct_id());
        return reviewService.save(review);
    }

}