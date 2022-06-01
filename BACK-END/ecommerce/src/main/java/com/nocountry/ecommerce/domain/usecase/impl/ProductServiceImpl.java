package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.handler.NotFoundException;
import com.nocountry.ecommerce.common.exception.handler.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.repository.CategoryRepository;
import com.nocountry.ecommerce.domain.repository.MarkRepository;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.usecase.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MarkRepository markRepository;
    private final CategoryRepository categoryRepository;

    //===================Find===================//

    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    //===================Create===================//

    public Long create(Product product) {
        if (productRepository.findByName(product.getName()).isPresent())
            throw new AlreadyExistsException("the name " + product.getName() + " is already in use");

        Long idMark = product.getMark().getId();
        Long idCategory = product.getCategory().getId();

        Mark mark = markRepository.findById(idMark)
                .orElseThrow(() -> new NotFoundException("Mark not found by id: " + idMark));
        Category category = categoryRepository.findById(idCategory)
                .orElseThrow(() -> new NotFoundException("Category not found id: " + idCategory));

        product.setMark(mark);
        product.setCategory(category);
        productRepository.save(product);
        return product.getId();
    }

    //===================Update===================//

    public void update(Long id, Product request) {
        if (productRepository.findByName(request.getName()).isPresent())
            throw new AlreadyExistsException("The name " + request.getName() + " is already in use");

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Product not found by id: " + id));
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDetail(request.getDetail());
        product.setImage(request.getImage());
        productRepository.save(product);
    }

    @Override
    public void updateAvailable(Long id) {
        Product product = productRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("Product not found by id: " + id));

        product.setIsAvailable(true);
        productRepository.save(product);
    }

    //===================Delete===================//

    public void delete(Long id) {
        Product product = productRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("Product not found with id: " + id));
        productRepository.delete(product);
    }

}
