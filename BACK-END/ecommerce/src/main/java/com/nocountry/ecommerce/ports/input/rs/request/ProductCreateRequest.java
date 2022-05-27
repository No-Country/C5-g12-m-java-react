package com.nocountry.ecommerce.ports.input.rs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {
   private String name;
   private Double price;
   private Long stock;
   private String detail;
   private String image;
   private Long mark;
   private Long category;
}
