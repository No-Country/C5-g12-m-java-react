package com.nocountry.ecommerce.domain.repository;

import com.nocountry.ecommerce.domain.model.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product, Long> {
   Product findByName(String name);
}
