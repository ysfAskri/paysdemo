package com.example.demo.controller;

import com.example.demo.dto.DepartementDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Departement API")
public interface DepartementController {
    @ApiOperation("Add new data")
    public DepartementDTO save(@RequestBody DepartementDTO departement);

    @ApiOperation("Find by Id")
    public DepartementDTO findById(@PathVariable("id") long id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") long id);

    @ApiOperation("Find all data")
    public List<DepartementDTO> list();

    @ApiOperation("Pagination request")
    public Page<DepartementDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public DepartementDTO update(@RequestBody DepartementDTO dto);
}