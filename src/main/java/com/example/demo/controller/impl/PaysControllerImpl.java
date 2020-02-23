package com.example.demo.controller.impl;

import com.example.demo.controller.PaysController;
import com.example.demo.dto.PaysDTO;
import com.example.demo.mapper.PaysMapper;
import com.example.demo.model.Pays;
import com.example.demo.service.PaysService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/api/pays")
@RestController
public class PaysControllerImpl implements PaysController {

    private final PaysService paysService;
    private final PaysMapper paysMapper;


    public PaysControllerImpl(PaysService paysService, PaysMapper paysMapper) {
        this.paysService = paysService;
        this.paysMapper = paysMapper;
    }


    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PaysDTO save(@RequestBody PaysDTO paysDTO) {
        Pays pays = paysMapper.toEntity(paysDTO);
        return paysMapper.toDto(paysService.save(pays));
    }

    @Override
    @GetMapping("/{id}")
    public PaysDTO findById(@PathVariable("id") String id) {
        Pays entity = paysService.findById(id).orElse(null);
        return paysMapper.toDto(entity);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        paysService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PaysDTO> list() {
        return paysMapper.toDtoList(paysService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PaysDTO> pageQuery(Pageable pageable) {
        Page<Pays> entityPage = paysService.findAll(pageable);
        List<PaysDTO> dtoList = entityPage
                .stream()
                .map(paysMapper::toDto).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, entityPage.getTotalElements());
    }

    @Override
    @PutMapping
    public PaysDTO update(@RequestBody PaysDTO paysDTO) {
        Pays pays = paysMapper.toEntity(paysDTO);
        return paysMapper.toDto(paysService.updateById(pays));
    }
}
