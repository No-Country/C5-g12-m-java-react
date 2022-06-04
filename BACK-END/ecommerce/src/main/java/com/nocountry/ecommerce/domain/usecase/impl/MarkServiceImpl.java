package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.error.ExistingNameException;
import com.nocountry.ecommerce.common.exception.error.ResourceNotFoundException;
import com.nocountry.ecommerce.domain.model.Mark;
import com.nocountry.ecommerce.domain.repository.MarkRepository;
import com.nocountry.ecommerce.domain.usecase.MarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MarkServiceImpl implements MarkService {


    private static final String NAME = "Mark";

    private final MarkRepository markRepository;

    @Transactional(readOnly = true)
    public Mark getByIdIfExists(Long id) {
        return markRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAME, id));
    }

    @Override
    @Transactional(readOnly = true)
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
        Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAME, id));

        existsName(request.getName());
        mark.setName(request.getName());
    }

    @Override
    @Transactional
    public void updateAvailable(Long id) {
        Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAME, id));

        mark.setIsAvailable(true);
        markRepository.save(mark);
    }

    private void existsName(String name) {
        if (markRepository.existsByName(name))
            throw new ExistingNameException(name);
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        Mark mark = markRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(NAME, id));
        markRepository.deleteById(mark.getId());
    }

}
