package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import com.github.qualquercoisavinteconto.models.Category;
import com.github.qualquercoisavinteconto.models.Product;
import com.github.qualquercoisavinteconto.models.Purchase;
import com.github.qualquercoisavinteconto.models.Review;
import com.github.qualquercoisavinteconto.models.Role;

import jakarta.persistence.Column;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdsDTO {
    
    private String description;
    private Long product_id;
    
}
