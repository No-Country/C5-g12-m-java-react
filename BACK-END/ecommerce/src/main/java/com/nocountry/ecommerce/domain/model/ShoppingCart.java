package com.nocountry.ecommerce.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class ShoppingCart {

    private User user;

    private Long total;

    private ArrayList<Product> productList;

    private void addProduct(Product product) {
        this.productList.add(product);
    }

}
