package com.nocountry.ecommerce.domain.usecase;

import com.nocountry.ecommerce.domain.model.Mark;

import java.util.List;

public interface MarkService {

    Mark getByIdIfExists(Long id);

    List<Mark> findAll();

    Long save(Mark entity);

    void update(Long id, Mark entity);

    void deleteById(Long id);
}
