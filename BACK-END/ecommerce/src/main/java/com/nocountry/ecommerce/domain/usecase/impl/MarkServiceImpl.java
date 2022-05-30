package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.handler.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.repository.MarkRepository;
import com.nocountry.ecommerce.domain.usecase.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MarkServiceImpl implements MarkService {

    private final MarkRepository markRepository;

    @Transactional
    public Mark getByIdIfExists(Long id) {
        return markRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
    }

    @Override
    @Transactional
    public List<Mark> findAll() {
        return markRepository.findAll();
    }

    @Override
    @Transactional
    public Long save(Mark request) {
        existsName(request.getName());
        return markRepository.save(request).getId();
    }

    @Override
    @Transactional
    public void update(Long id, Mark request) {
        Mark mark = markRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        existsName(request.getName());
        mark.setName(request.getName());
        mark.setIsAvailable(request.getIsAvailable());
    }

    private void existsName(String name) {
        if (markRepository.findByName(name).isPresent())
            throw new AlreadyExistsException("this name is already in use ");
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        Mark mark = markRepository.findById(id).orElseThrow(() -> new com.nocountry.ecommerce.common.exception.handler.ResourceNotFoundException(id));
        markRepository.deleteById(mark.getId());
    }

}
