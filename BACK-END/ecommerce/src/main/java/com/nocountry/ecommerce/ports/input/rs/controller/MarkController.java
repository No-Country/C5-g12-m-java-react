package com.nocountry.ecommerce.ports.input.rs.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.usecase.impl.MarkServiceImpl;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(MARK_URI)
public class MarkController {
    
    private final MarkServiceImpl markServiceImpl;

     //====================Gets====================//

    @GetMapping
   public ResponseEntity<?> getAllProducts() throws Exception {
      return ResponseEntity.ok(markServiceImpl.findAll());
   }

   //====================Get by id====================//

   @GetMapping(path = "/{id}")
   public ResponseEntity<?> getById(@PathVariable("id") @NotNull @Valid Long id) throws Exception {
      return ResponseEntity.ok(markServiceImpl.findById(id));
   }


    //====================Posts====================//

   @PostMapping(path = "/create")
   public ResponseEntity<?> createMark(@RequestBody @Valid Mark mark) throws Exception {
      return ResponseEntity.ok().body(markServiceImpl.save(mark));
   }

   //====================Puts====================//

   @PutMapping(path = "update/{id}")
   public ResponseEntity<?> updateMark(@PathVariable("id") @NotNull @Valid Long id,@RequestBody @Valid Mark mark) throws Exception {
      return ResponseEntity.ok().body(markServiceImpl.update(id, mark));
   }

   //====================Deletes====================//

   @DeleteMapping(path = "{id}")
   public ResponseEntity<?> deleteMark(@PathVariable @NotBlank @Valid Long id) throws Exception {
      markServiceImpl.delete(id);
      return ResponseEntity.ok().build();
   }
}
