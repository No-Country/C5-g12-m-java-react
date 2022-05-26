package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.AlreadyExistsException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.repository.CategoryRepository;
import com.nocountry.ecommerce.domain.repository.MarkRepository;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.usecase.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

   private final ProductRepository repository;
   private final MarkRepository markRepository;
   private final CategoryRepository categoryRepository;

   //===================Find===================//

   public List<Product> findAll() {
      return repository.findAll();
   }

   //===================Create===================//

   @Transactional
   public Long create(Product aux) {
      if (repository.existByName(aux.getName()))
         throw new AlreadyExistsException("there is a product with the same name");

      aux.setMark(findMark(aux.getMark().getId()));
      aux.setCategory(findCategory(aux.getCategory().getId()));

      repository.save(aux);
      return aux.getId();
   }

   /**
    * auxiliary methods to set mark and category
    * findMark and findCategory
    */

   private Mark findMark(Long id) {
      return markRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("mark not found"));
   }

   private Category findCategory(Long id) {
      return categoryRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("category not found"));
   }

   //===================Update===================//

   @Transactional
   public void update(Long id, Product aux) {
      if (repository.existByName(aux.getName()))
         throw new AlreadyExistsException("there is a product with the same name");

      Product product = repository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("product not found"));
      product.setName(aux.getName());
      product.setPrice(aux.getPrice());
      product.setDetail(aux.getDetail());
      product.setImage(aux.getImage());
      repository.save(product);
   }

   //===================Delete===================//

   @Transactional
   public void delete(Long id) {
      if (repository.findById(id).isPresent()) repository.deleteById(id);
      else throw new ResourceNotFoundException("product not found by id: " + id);
   }
}
