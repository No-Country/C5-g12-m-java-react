package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.repository.CategoryRepository;
import com.nocountry.ecommerce.domain.usecase.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    private final static String NAME = "Category";

    @Override
    @Transactional
    public Category getByIdIfExists(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME, id));
    }

    @Override
    @Transactional
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    @Transactional
    public Long save(Category request) {
        existsName(request.getName());
        return categoryRepository.save(request).getId();
    }

    @Override
    @Transactional
    public void update(Long id, Category request) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME, id));

        existsName(request.getName());
        category.setName(request.getName());

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAME, id));
        categoryRepository.deleteById(category.getId());

    }

    private void existsName(String name) {
        if (categoryRepository.findByName(name).isPresent())
            throw new AlreadyExistsException("this name is already in use ");
    }


}
