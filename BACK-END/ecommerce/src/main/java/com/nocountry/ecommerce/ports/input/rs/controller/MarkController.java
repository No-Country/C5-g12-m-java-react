package com.nocountry.ecommerce.ports.input.rs.controller;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.usecase.impl.MarkServiceImpl;
import com.nocountry.ecommerce.ports.input.rs.mapper.MarkMapper;
import com.nocountry.ecommerce.ports.input.rs.request.MarkCreateRequest;
import com.nocountry.ecommerce.ports.input.rs.request.MarkUpdateRequest;
import com.nocountry.ecommerce.ports.input.rs.response.MarkDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.MARK_URI;

import java.net.URI;
import java.util.List;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(MARK_URI)
public class MarkController {
    
    private final MarkServiceImpl markServiceImpl;
    private final MarkMapper mapper;

     //====================Gets====================//

    @GetMapping
   public ResponseEntity<List<MarkDetails>> getAllProducts() throws Exception {
      return ResponseEntity.ok(mapper.MarkListToMarkDetailList(markServiceImpl.findAll()));
   }

   //====================Get by id====================//

   @GetMapping(path = "/{id}")
   public ResponseEntity<MarkDetails> getById(@PathVariable("id") @NotNull @Valid Long id) throws Exception {
      return ResponseEntity.ok(mapper.MarkToMarkDetails(markServiceImpl.findById(id)));
   }


    //====================Posts====================//

   @PostMapping(path = "/create")
   public ResponseEntity<Void> createMark(@RequestBody @Valid MarkCreateRequest markCreateRequest){
    long id = markServiceImpl.save(mapper.CreateMarkToMark(markCreateRequest));
    URI location = ServletUriComponentsBuilder.fromCurrentRequest()
       .path("/{id}").buildAndExpand(id)
       .toUri();
    return ResponseEntity.created(location).build();
   }

   //====================Patchs====================//

   @PatchMapping(path = "/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void updateMark(@PathVariable("id") @NotNull Long id,
   @RequestBody @Valid MarkUpdateRequest request) {
    markServiceImpl.update(id, mapper.UpdateMarkToMark(request));
}

   //====================Deletes====================//

   @DeleteMapping(path = "/{id}")
   @ResponseStatus(HttpStatus.NO_CONTENT)
   public void deleteMark(@PathVariable @NotBlank @Valid Long id) {
      markServiceImpl.delete(id);
   }
}
