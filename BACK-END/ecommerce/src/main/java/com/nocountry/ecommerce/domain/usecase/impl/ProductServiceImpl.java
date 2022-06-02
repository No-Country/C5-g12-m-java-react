package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.ExistingNameException;
import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.repository.CategoryRepository;
import com.nocountry.ecommerce.domain.repository.MarkRepository;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.usecase.ProductService;
import com.nocountry.ecommerce.ports.input.rs.request.ProductFilterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MarkRepository markRepository;
    private final CategoryRepository categoryRepository;

    //===================Find===================//

    @Transactional(readOnly = true)
    public Page<Product> pageOfProduct(ProductFilterRequest request) {

        Integer page = request.getPage();
        Pageable pageable = PageRequest.of(page, 3);

        return productRepository.findByMarkAndCategory(
           request.getMark(), request.getCategory(), pageable
        );
    }

    //===================Create===================//

    public Long create(Product product) {
        existsName(product.getName());
        Long idMark = product.getMark().getId();
        Long idCategory = product.getCategory().getId();

        Mark mark = markRepository.findById(idMark)
                .orElseThrow(() -> new ResourceNotFoundException("Mark",idMark));
        Category category = categoryRepository.findById(idCategory)
                .orElseThrow(() -> new ResourceNotFoundException("Category",idCategory));

        product.setMark(mark);
        product.setCategory(category);
        productRepository.save(product);
        return product.getId();
    }

    //===================Update===================//

    public void update(Long id, Product request) {
        existsName(request.getName());

        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product",id));
        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDetail(request.getDetail());
        product.setImage(request.getImage());
        productRepository.save(product);
    }

    @Override
    public void updateAvailable(Long id) {
        Product product = productRepository.findById(id)
           .orElseThrow(() -> new ResourceNotFoundException("Product",id));

        product.setIsAvailable(true);
        productRepository.save(product);
    }

    //===================Delete===================//

    public void delete(Long id) {
        Product product = productRepository.findById(id)
           .orElseThrow(() -> new ResourceNotFoundException("Product",id));
        productRepository.delete(product);
    }

    private void existsName(String name) {
        if (productRepository.existsByName(name))
            throw new ExistingNameException(name);
    }

}
