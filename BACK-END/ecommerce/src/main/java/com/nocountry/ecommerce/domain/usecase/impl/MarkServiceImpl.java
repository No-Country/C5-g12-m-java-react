package com.nocountry.ecommerce.domain.usecase.impl;

import com.nocountry.ecommerce.common.exception.handler.AlreadyExistsException;
import com.nocountry.ecommerce.common.exception.handler.NotFoundException;
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
        return markRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("Mark not found with id: " + id));
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
        Mark mark = markRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("Mark not found with id: " + id));

        existsName(request.getName());
        mark.setName(request.getName());
    }

    @Override
    @Transactional
    public void updateAvailable(Long id) {
        Mark mark = markRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("Mark not found with id: " + id));

        mark.setIsAvailable(true);
        markRepository.save(mark);
    }

    private void existsName(String name) {
        if (markRepository.findByName(name).isPresent())
            throw new AlreadyExistsException("The name: " + name + " is already in use");
    }


    @Override
    @Transactional
    public void deleteById(Long id) {
        Mark mark = markRepository.findById(id)
           .orElseThrow(() -> new NotFoundException("Mark not found with id: " + id));
        markRepository.deleteById(mark.getId());
    }

}
