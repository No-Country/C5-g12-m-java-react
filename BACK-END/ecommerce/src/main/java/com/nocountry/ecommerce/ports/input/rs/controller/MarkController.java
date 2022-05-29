package com.nocountry.ecommerce.ports.input.rs.controller;

import com.nocountry.ecommerce.domain.usecase.MarkService;
import com.nocountry.ecommerce.ports.input.rs.mapper.MarkMapper;
import com.nocountry.ecommerce.ports.input.rs.request.MarkCreateRequest;
import com.nocountry.ecommerce.ports.input.rs.request.MarkUpdateRequest;
import com.nocountry.ecommerce.ports.input.rs.response.MarkDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.net.URI;
import java.util.List;

import static com.nocountry.ecommerce.ports.input.rs.api.ApiConstants.MARK_URI;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping(MARK_URI)
public class MarkController {

    private final MarkService markService;
    private final MarkMapper mapper;

    //====================Gets====================//

    @GetMapping
    public ResponseEntity<List<MarkDetails>> getAllProducts() throws Exception {
        return ResponseEntity.ok(mapper.MarkListToMarkDetailList(markService.findAll()));
    }

    //====================Get by id====================//

    @GetMapping(path = "/{id}")
    public ResponseEntity<MarkDetails> getById(@Valid @NotNull @PathVariable("id") Long id) throws Exception {
        return ResponseEntity.ok(mapper.MarkToMarkDetails(markService.getByIdIfExists(id)));
    }


    //====================Posts====================//

    @PostMapping(path = "/create")
    public ResponseEntity<Void> createMark(@RequestBody MarkCreateRequest markCreateRequest) {
        long id = markService.save(mapper.CreateMarkToMark(markCreateRequest));
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(id)
                .toUri();
        return ResponseEntity.created(location).build();
    }

    //====================Patchs====================//

    @PatchMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateMark(@Valid @NotNull @PathVariable("id") Long id,
                           @RequestBody MarkUpdateRequest request) {
        markService.update(id, mapper.UpdateMarkToMark(request));
    }

    //====================Deletes====================//

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMark(@Valid @NotNull @PathVariable Long id) {
        markService.deleteById(id);
    }
}
