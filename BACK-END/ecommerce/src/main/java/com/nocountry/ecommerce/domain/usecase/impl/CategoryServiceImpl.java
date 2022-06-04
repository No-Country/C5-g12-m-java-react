package com.nocountry.ecommerce.domain.usecase.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.handler.NotFoundException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.repository.CategoryRepository;
import com.nocountry.ecommerce.domain.usecase.CategoryService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Category getByIdIfExists(Long id) {
        return categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id));
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
        Category category = categoryRepository.findById(id).orElseThrow(() -> new NotFoundException(id));

        existsName(request.getName());
        category.setName(request.getName());

    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new com.nocountry.ecommerce.common.exception.handler.ResourceNotFoundException(id));
        categoryRepository.deleteById(category.getId());

    }

    private void existsName(String name) {
        if (categoryRepository.findByName(name).isPresent())
            throw new AlreadyExistsException("this name is already in use ");
    }

}
