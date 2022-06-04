package com.nocountry.ecommerce.ports.input.rs.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductCreateRequest {
   @NotEmpty
   @NotBlank
   private String name;

   @NotEmpty
   private Double price;

   @NotEmpty
   private Long stock;

   @NotEmpty
   @NotBlank
   private String detail;

   @NotEmpty
   @NotBlank
   private String image;

   @NotEmpty
   private Long mark;

   @NotEmpty
   private Long category;
}
