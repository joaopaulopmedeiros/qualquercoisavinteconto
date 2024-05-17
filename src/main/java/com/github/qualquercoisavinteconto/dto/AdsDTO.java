package com.github.qualquercoisavinteconto.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class AdsDTO {
    private String description;
    @JsonProperty("product_id")
    private Long productId;    
}
