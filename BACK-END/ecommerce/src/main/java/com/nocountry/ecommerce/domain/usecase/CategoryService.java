package com.nocountry.ecommerce.domain.usecase;

import java.util.List;

import com.nocountry.ecommerce.domain.model.Category;

public interface CategoryService extends ActiveAvailable{
    Category getByIdIfExists(Long id);

    List<Category> findAll();

    Long save(Category entity);

    void update(Long id, Category request);

    void deleteById(Long id);
}
