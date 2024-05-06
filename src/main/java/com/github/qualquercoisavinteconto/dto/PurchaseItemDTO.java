package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
{
  "product_id": 1,
  "quantity": 2
}
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDTO {

  private Long product_id;
  private Integer quantity;
  
}
