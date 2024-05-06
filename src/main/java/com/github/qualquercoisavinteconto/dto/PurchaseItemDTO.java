package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
{
  "product_id": 1,
  "purchase_id" is not necessary, because the purchase_id is in the URL
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
