package com.nocountry.ecommerce.domain.usecase;

import java.util.List;

public interface MarkService<E> {
    public List<E> findAll() throws Exception;
    public E findById(Long id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public void delete(Long id) throws Exception;
}
