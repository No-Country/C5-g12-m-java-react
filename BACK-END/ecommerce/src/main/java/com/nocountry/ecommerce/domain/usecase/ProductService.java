package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductService extends ActiveAvailable {
    List<Product> findAll();

    Long create(Product product);

    void update(Long id, Product product);

    void delete(Long id);

}
