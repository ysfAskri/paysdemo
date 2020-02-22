package com.example.demo.service.impl;

import com.example.demo.dao.PaysRepository;
import com.example.demo.mapper.PaysMapper;
import com.example.demo.model.Pays;
import com.example.demo.service.PaysService;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PaysServiceImpl implements PaysService {
    private final PaysRepository repository;
    private PaysMapper mapper = Mappers.getMapper(PaysMapper.class);

    public PaysServiceImpl(PaysRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pays save(Pays entity) {
        return repository.save(entity);
    }

    @Override
    public void save(List<Pays> entities) {
        repository.saveAll(entities);
    }

    @Override
    public void deleteById(String id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Pays> findById(String id) {
        return repository.findById(id);
    }

    @Override
    public List<Pays> findAll() {
        return (List<Pays>) repository.findAll();
    }

    @Override
    public Page<Pays> findAll(Pageable pageable) {
        Page<Pays> entityPage = repository.findAll(pageable);
        List<Pays> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Pays updateById(Pays entity) {
        Optional<Pays> optionalDto = findById(entity.getId());
        if (optionalDto.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
