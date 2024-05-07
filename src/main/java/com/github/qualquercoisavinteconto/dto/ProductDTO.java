package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import com.github.qualquercoisavinteconto.models.Category;
import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.Review;
import com.github.qualquercoisavinteconto.models.Role;

import jakarta.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {
    
    private String name;
    private double price;
    private List<Review> reviews;
    private List<Category> categories;
    
}
