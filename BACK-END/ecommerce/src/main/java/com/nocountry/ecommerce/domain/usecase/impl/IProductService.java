package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.usecase.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IProductService implements ProductService {

   private final ProductRepository repository;

   @Transactional(readOnly = true)
   public List<Product> findAll() {
      return repository.findAll();
   }

   public Product create(Product aux) throws Exception {
      if(repository.findByName(aux.getName()) != null)
         throw new Exception("there is a product with the same name");
      return repository.save(aux);
   }

   public Product update(Long id, Product aux) {

      Product product = repository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("product not found"));

      product.setName(aux.getName());
      product.setPrice(aux.getPrice());
      product.setDetail(aux.getDetail());
      product.setImage(aux.getImage());

      return product;
   }

   public void delete(Long id) {
      if (repository.findById(id).isPresent()) repository.deleteById(id);
      else throw new ResourceNotFoundException("product not found by id: " + id);
   }


}
