package com.example.demo.controller.impl;

import com.example.demo.controller.DepartementController;
import com.example.demo.dto.DepartementDTO;
import com.example.demo.mapper.DepartementMapper;
import com.example.demo.model.Departement;
import com.example.demo.service.DepartementService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/departement")
@RestController
public class DepartementControllerImpl implements DepartementController {
    private final DepartementService departementService;
    private final DepartementMapper departementMapper;

    public DepartementControllerImpl(DepartementService departementService, DepartementMapper departementMapper) {
        this.departementService = departementService;
        this.departementMapper = departementMapper;
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public DepartementDTO save(@RequestBody DepartementDTO departementDTO) {
        Departement departement = departementMapper.toEntity(departementDTO);
        return departementMapper.toDto(departementService.save(departement));
    }

    @Override
    @GetMapping("/{id}")
    public DepartementDTO findById(@PathVariable("id") long id) {
        Departement departement = departementService.findById(id).orElse(null);
        return departementMapper.toDto(departement);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") long id) {
        departementService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<DepartementDTO> list() {
        return departementMapper.toDtoList(departementService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<DepartementDTO> pageQuery(Pageable pageable) {
        Page<Departement> departementPage = departementService.findAll(pageable);
        List<DepartementDTO> dtoList = departementPage
                .stream()
                .map(departementMapper::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, departementPage.getTotalElements());
    }

    @Override
    @PutMapping
    public DepartementDTO update(@RequestBody DepartementDTO departementDTO) {
        Departement departement = departementMapper.toEntity(departementDTO);
        return departementMapper.toDto(departementService.updateById(departement));
    }
}
