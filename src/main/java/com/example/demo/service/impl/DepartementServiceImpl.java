package com.example.demo.service.impl;

import com.example.demo.dao.DepartementRepository;
import com.example.demo.dto.DepartementDTO;
import com.example.demo.mapper.DepartementMapper;
import com.example.demo.model.Departement;
import com.example.demo.service.DepartementService;
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
public class DepartementServiceImpl implements DepartementService {
    private final DepartementRepository repository;

    public DepartementServiceImpl(DepartementRepository repository) {
        this.repository = repository;
    }

    @Override
    public Departement save(Departement entity) {
        return repository.save(entity);
    }

    @Override
    public List<Departement> save(List<Departement> entities) {
        return (List<Departement>) repository.saveAll(entities);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Departement> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Departement> findAll() {
        return (List<Departement>) repository.findAll();
    }

    @Override
    public Page<Departement> findAll(Pageable pageable) {
        Page<Departement> entityPage = repository.findAll(pageable);
        List<Departement> entities = entityPage.getContent();
        return new PageImpl<>(entities, pageable, entityPage.getTotalElements());
    }

    @Override
    public Departement updateById(Departement entity) {
        Optional<Departement> optional = findById(entity.getId());
        if (optional.isPresent()) {
            return save(entity);
        }
        return null;
    }
}
