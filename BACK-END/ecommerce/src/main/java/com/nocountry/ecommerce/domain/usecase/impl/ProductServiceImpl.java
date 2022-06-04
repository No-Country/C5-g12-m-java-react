package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.ExistingNameException;
import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Category;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.model.Product;
import com.nocountry.ecommerce.domain.repository.ProductRepository;
import com.nocountry.ecommerce.domain.usecase.CategoryService;
import com.nocountry.ecommerce.domain.usecase.MarkService;
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

    private static final String NAME = "Product";

    private final ProductRepository productRepository;
    private final MarkService markService;
    private final CategoryService categoryService;

    //===================Find===================//

    @Transactional(readOnly = true)
    public Page<Product> pageOfProduct(ProductFilterRequest request) {

        Integer page = request.getPage();
        Pageable pageable = PageRequest.of(page, 3);

        return productRepository.findByNameAndMarkAndCategory(
                request.getName(), request.getMark(), request.getCategory(), pageable
        );
    }

    //===================Create===================//

    public Long create(Product product) {
        existsName(product.getName());
        Long idMark = product.getMark().getId();
        Long idCategory = product.getCategory().getId();

        Mark mark = markService.getByIdIfExists(idMark);
        Category category = categoryService.getByIdIfExists(idCategory);

        product.setMark(mark);
        product.setCategory(category);
        save(product);
        return product.getId();
    }

    //===================Update===================//

    public void update(Long id, Product request) {
        existsName(request.getName());

        Product product = getByIdIfExist(id);

        product.setName(request.getName());
        product.setPrice(request.getPrice());
        product.setDetail(request.getDetail());
        product.setImage(request.getImage());
        save(product);
    }


    public void updateAvailable(Long id) {
        Product product = getByIdIfExist(id);

        product.setIsAvailable(true);
        save(product);
    }

    //===================Delete===================//

    public void delete(Long id) {
        Product product = getByIdIfExist(id);
        productRepository.delete(product);
    }

    public void save(Product product) {
        productRepository.save(product);
    }


    public Product getByIdIfExist(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(NAME, id));
    }

    private void existsName(String name) {
        if (productRepository.existsByName(name))
            throw new ExistingNameException(name);
    }

}
