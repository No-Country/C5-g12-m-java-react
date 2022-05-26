package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.usecase.impl.ProductServiceImpl;
import com.nocountry.ecommerce.ports.input.rs.mapper.ProductMapper;
import com.nocountry.ecommerce.ports.input.rs.request.CreateProductRequest;
import com.nocountry.ecommerce.ports.input.rs.response.ProductDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import java.net.URI;
import java.util.List;

import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.PRODUCT_URI;

@RestController
@RequestMapping(PRODUCT_URI)
@RequiredArgsConstructor
public class ProductController {

   private final ProductServiceImpl service;
   private final ProductMapper mapper;

   //====================Gets====================//

   @GetMapping
   public ResponseEntity<List<ProductDetails>> getAllProducts() {
      return ResponseEntity.ok(
         mapper.ListProductToProductDetailList(service.findAll())
      );
   }

   //====================Posts====================//

   @PostMapping
   public ResponseEntity<Void> createProduct(@RequestBody @Valid CreateProductRequest aux) {
      long id = service.create(mapper.CreateProductToProduct(aux));
      URI location = ServletUriComponentsBuilder.fromCurrentRequest()
         .path("{id}").buildAndExpand(id)
         .toUri();
      return ResponseEntity.created(location).build();
   }

   //====================Puts====================//


   @PutMapping(path = "/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void updateProduct(@PathVariable("id") @NotNull Long id, @RequestBody @Valid Product aux) {
      service.update(id, aux);
   }

   //====================Deletes====================//

   @DeleteMapping(path = "/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deleteProduct(@PathVariable @NotBlank @Valid Long id) {
      service.delete(id);
   }
}
