package com.nocountry.ecommerce.domain.repository;

import com.nocountry.ecommerce.domain.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   @Query("select case when count(c) > 0 then true else false end from Product p where p.name = ?1")
   boolean existByName(String name);
}
