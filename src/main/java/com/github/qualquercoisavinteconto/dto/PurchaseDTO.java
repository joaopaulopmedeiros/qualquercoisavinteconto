package com.github.qualquercoisavinteconto.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* PurchaseDTO
{
  "user_id": 1,
  "status": "approved",
  "items": [
    {
      "product_id": 1,
      "quantity": 2
    },
    {
      "product_id": 2,
      "quantity": 1
    }
  ]
}
*/

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PurchaseDTO {
  
  private Long user_id;
  private String status;
  private List<PurchaseItemDTO> items;

}
