package com.nocountry.ecommerce.domain.repository;

import com.nocountry.ecommerce.domain.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

   boolean existsByName(String name);

   Optional<Product> findById(Long id);

   @Query("select p from Product p where " +
      "(?1 is null or p.mark.name like %?1%) " +
      "and (?2 is null or p.category.name like %?2%)")
   Page<Product> findByMarkAndCategory(String mark, String category, Pageable pageable);
}
