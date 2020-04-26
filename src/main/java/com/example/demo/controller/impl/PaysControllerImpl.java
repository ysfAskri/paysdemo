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

@RequestMapping("/pays")
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
        Pays pays = paysMapper.asEntity(paysDTO);
        return paysMapper.asDTO(paysService.save(pays));
    }

    @Override
    @GetMapping("/{id}")
    public PaysDTO findById(@PathVariable("id") String id) {
        Pays pays = paysService.findById(id).orElse(null);
        return paysMapper.asDTO(pays);
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") String id) {
        paysService.deleteById(id);
    }

    @Override
    @GetMapping
    public List<PaysDTO> list() {
        return paysMapper.asDTOList(paysService.findAll());
    }

    @Override
    @GetMapping("/page-query")
    public Page<PaysDTO> pageQuery(Pageable pageable) {
        Page<Pays> paysPage = paysService.findAll(pageable);
        List<PaysDTO> dtoList = paysPage
                .stream()
                .map(paysMapper::asDTO).collect(Collectors.toList());
        return new PageImpl<>(dtoList, pageable, paysPage.getTotalElements());
    }

    @Override
    @PutMapping("/{id}")
    public PaysDTO update(@RequestBody PaysDTO paysDTO, @PathVariable String id) {
        Pays pays = paysMapper.asEntity(paysDTO);
        return paysMapper.asDTO(paysService.update(pays, id));
    }
}
