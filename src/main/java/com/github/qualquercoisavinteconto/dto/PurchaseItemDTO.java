package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Body da requisição:
{
  "purchase_id": 1,
  "product_id": 1,
  "quantity": 2
}
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseItemDTO {

  private Long purchase_id;
  private Long product_id;
  private Integer quantity;
  
}
