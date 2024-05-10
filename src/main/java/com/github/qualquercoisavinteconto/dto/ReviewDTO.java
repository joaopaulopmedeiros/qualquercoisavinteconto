package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Body da requisição:
{
  "description": "Muito bom",
  "stars": 5,
  "product_id": 1,
  "user_id": 1
}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReviewDTO {
  
  private String description;
  private Integer stars;
  private Long product_id;
  private Long user_id;

}
