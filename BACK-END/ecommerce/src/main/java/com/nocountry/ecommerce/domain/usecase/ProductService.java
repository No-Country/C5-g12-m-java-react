package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductService {
   List<Product> findAll();
   Long create(Product aux) throws Exception;
   void update(Long id, Product aux);
   void delete(Long id);
}
