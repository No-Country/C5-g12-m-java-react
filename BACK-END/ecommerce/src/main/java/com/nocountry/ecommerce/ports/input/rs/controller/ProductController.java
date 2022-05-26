package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.usecase.impl.ProductServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.PRODUCT_URI;

@RestController
@RequestMapping(PRODUCT_URI)
@RequiredArgsConstructor
public class ProductController {

   private final ProductServiceImpl service;

   //====================Gets====================//

   @GetMapping
   public ResponseEntity<?> getAllProducts() {
      return ResponseEntity.ok(service.findAll());
   }

   //====================Posts====================//

   @PostMapping(path = "create")
   public ResponseEntity<?> createProduct(@RequestBody @Valid Product aux) throws Exception {
      return ResponseEntity.ok().body(service.create(aux));
   }

   //====================Puts====================//

   @PutMapping(path = "update/{id}")
   public ResponseEntity<?> updateProduct(@PathVariable("id") @NotNull @Valid Long id,
                                          @RequestBody @Valid Product aux) {
      return ResponseEntity.ok().body(service.update(id, aux));
   }

   //====================Deletes====================//

   @DeleteMapping(path = "{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public ResponseEntity<?> deleteProduct(@PathVariable @NotBlank @Valid Long id) {
      service.delete(id);
      return ResponseEntity.ok().build();
   }
}
