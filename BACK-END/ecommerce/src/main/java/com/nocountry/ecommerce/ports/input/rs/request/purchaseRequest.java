package com.nocountry.ecommerce.ports.input.rs.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class purchaseRequest {

    @NotEmpty
    @NotBlank
    private Long idUser;

    @NotEmpty
    private List<ProductRequestSimple> listProducts;
}
