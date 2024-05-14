package com.github.qualquercoisavinteconto.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/* Body da requisição:
{
  "user_id": 1,
  "street": "Rua de teste",
  "number": "123",
  "state": "SP",
  "city": "São Paulo"
}
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO {

    private Long user_id;
    private String street;
    private String number;
    private String state;
    private String city;
  
}
