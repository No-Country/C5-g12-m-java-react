package com.nocountry.ecommerce.ports.input.rs.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductUpdateRequest {
   @NotEmpty
   @NotBlank
   private String name;

   @NotEmpty
   private Double price;

   @NotEmpty
   @NotBlank
   private String detail;

   @NotEmpty
   @NotBlank
   private String image;
}
