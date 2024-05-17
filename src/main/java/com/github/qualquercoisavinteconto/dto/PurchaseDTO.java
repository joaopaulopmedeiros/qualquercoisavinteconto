package com.github.qualquercoisavinteconto.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
  
  @JsonProperty("user_id")
  private Long userId;
  private String status;
  private List<PurchaseItemDTO> items;

}
