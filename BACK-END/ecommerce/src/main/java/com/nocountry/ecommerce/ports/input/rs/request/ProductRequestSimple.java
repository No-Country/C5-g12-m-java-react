package com.nocountry.ecommerce.ports.input.rs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductRequestSimple {

    @NotEmpty
    @NotBlank
    private Long id;

    @NotEmpty
    @NotBlank
    private Integer amount;
}
