package com.nocountry.ecommerce.ports.input.rs.specification;

import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.ports.input.rs.request.ProductFilterRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductSpecification {

   public Specification<Product> specification(ProductFilterRequest request) {
      return ((root, query, criteriaBuilder) -> {

         List<Predicate> predicates = new ArrayList<>();

         if(request.getName() != null)
            predicates.add(criteriaBuilder.like(root.get("name"), "%" + request.getName() + "%"));

         if(request.getCategory() != null) {
            Join<Product, Category> join = root.join("category");
            predicates.add(criteriaBuilder.like(join.get("name"), "%" + request.getCategory() + "%"));
         }

         if(request.getMark() != null) {
            Join<Product, Mark> join = root.join("mark");
            predicates.add(criteriaBuilder.like(join.get("name"), "%" + request.getMark() + "%"));
         }

         return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
      });
   }
}
