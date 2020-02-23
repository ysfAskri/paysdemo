package com.example.demo.service.impl;

import com.example.demo.dao.PaysRepository;
import com.example.demo.model.Pays;
import com.example.demo.service.PaysService;
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

    public PaysServiceImpl(PaysRepository repository) {
        this.repository = repository;
    }

    @Override
    public Pays save(Pays entity) {
        return repository.save(entity);
    }

    @Override
    public List<Pays> save(List<Pays> entities) {
        return (List<Pays>) repository.saveAll(entities);
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
        Optional<Pays> optionalEntity = findById(entity.getId());
        if (optionalEntity.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
