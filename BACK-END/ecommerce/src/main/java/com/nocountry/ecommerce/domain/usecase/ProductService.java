package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Product;

import java.util.List;

public interface ProductService {
   List<Product> findAll();
   Product create(Product aux) throws Exception;
   Product update(Long id, Product aux);
   void delete(Long id);
}
