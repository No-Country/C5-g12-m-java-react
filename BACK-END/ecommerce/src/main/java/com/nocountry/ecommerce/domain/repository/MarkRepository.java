package com.nocountry.ecommerce.domain.repository;

import com.nocountry.ecommerce.domain.model.Mark;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {

    boolean existsByName(String name);

    @Query(
  value = "SELECT * FROM mark m WHERE m.is_available = 1", 
  nativeQuery = true)
    Collection<Mark> findAllActive();


}