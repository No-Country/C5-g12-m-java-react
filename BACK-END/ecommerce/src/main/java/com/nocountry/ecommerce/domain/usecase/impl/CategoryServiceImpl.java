package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.ExistingNameException;
import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.repository.CategoryRepository;
import com.nocountry.ecommerce.domain.usecase.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final String NAME = "Category";

    @Override
    @Transactional
    public Category getByIdIfExists(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME,id));
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Transactional
    public Long save(Category request) {
        existsName(request.getName());
        return categoryRepository.save(request).getId();
    }

    @Transactional
    public void update(Long id, Category request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME,id));

        existsName(request.getName());
        category.setName(request.getName());
        categoryRepository.save(category);
    }

    @Transactional
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAME,id));
        categoryRepository.deleteById(category.getId());

    }

    private void existsName(String name) {
        if (categoryRepository.findByName(name).isPresent())
            throw new ExistingNameException(name);
    }

}
