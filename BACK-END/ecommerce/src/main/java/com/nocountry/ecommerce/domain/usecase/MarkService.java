package com.nocountry.ecommerce.domain.usecase;

import java.util.List;

public interface MarkService<Mark> {
    public List<Mark> findAll() throws Exception;
    public Mark findById(Long id) throws Exception;
    public Mark save(Mark entity) throws Exception;
    public Mark update(Long id, Mark entity) throws Exception;
    public void delete(Long id) throws Exception;
}
