package com.nocountry.ecommerce.domain.repository;

import com.nocountry.ecommerce.domain.model.Mark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarkRepository extends JpaRepository<Mark, Long> {
}