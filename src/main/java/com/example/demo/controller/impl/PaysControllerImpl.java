package com.example.demo.controller.impl;

import com.example.demo.controller.PaysController;
import com.example.demo.dto.PaysDTO;
import com.example.demo.mapper.PaysMapper;
import com.example.demo.model.Pays;
import com.example.demo.service.PaysService;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequestMapping("/api/pays")
@RestController
public class PaysControllerImpl implements PaysController {

    private PaysMapper paysMapper= Mappers.getMapper(PaysMapper.class);

    private final PaysService paysService;

    public PaysControllerImpl(PaysService paysService) {
        this.paysService = paysService;
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
        List<PaysDTO> dtoList =entityPage
                .stream()
                .map(pays ->  paysMapper.toDto(pays)).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, entityPage.getTotalElements()) ;
    }

    @Override
    @PutMapping
    public PaysDTO update(@RequestBody PaysDTO dto) {
        Pays entity = paysMapper.toEntity(dto);
        return paysMapper.toDto(paysService.updateById(entity));
    }
}
