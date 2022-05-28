package com.nocountry.ecommerce.domain.usecase.impl;

import java.util.List;

import javax.transaction.Transactional;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.repository.MarkRepository;
import com.nocountry.ecommerce.domain.usecase.MarkService;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class MarkServiceImpl implements MarkService<Mark> {

    private final MarkRepository markRepository;

    @Override
    @Transactional
    public List<Mark> findAll() throws Exception {
        return markRepository.findAll();
    }

    @Override
    @Transactional
    public Mark findById(Long id) throws Exception {
        Mark mark = markRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("mark not found"));
        return mark;
    }

    @Override
    @Transactional
    public Mark save(Mark entity) throws Exception {
        if(markRepository.findByName(entity.getName()) != null)
        throw new Exception("there is a mark with the same name");
     return markRepository.save(entity);
    }

    @Override
    @Transactional
    public Mark update(Long id, Mark entity){
        Mark mark = markRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("mark not found"));
        if(markRepository.findByName(entity.getName()) != null){
            throw new AlreadyExistsException("there is a product with the same name");
        }
        mark.setName(entity.getName());
        return mark;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        if (markRepository.findById(id).isPresent()) markRepository.deleteById(id);
        else throw new ResourceNotFoundException("mark not found by id: " + id);
    }
    
}
