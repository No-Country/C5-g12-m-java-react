package com.nocountry.ecommerce.ports.input.rs.request;

import com.nocountry.ecommerce.domain.model.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceRequest {

    private Long idUser;

    private List<Product> listProducts;
}
