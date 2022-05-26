package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductService {
   List<Product> findAll();
   Long create(Product product) throws Exception;
   void update(Long id, Product product);
   void delete(Long id);
}
