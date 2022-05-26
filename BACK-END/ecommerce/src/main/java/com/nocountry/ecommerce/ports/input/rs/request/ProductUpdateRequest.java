package com.nocountry.ecommerce.ports.input.rs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateProductRequest {
   private String name;
   private Double price;
   private String detail;
   private String image;
}
