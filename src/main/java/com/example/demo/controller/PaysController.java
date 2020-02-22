package com.example.demo.controller;

import com.example.demo.dto.PaysDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Api(tags = "Pays API")
public interface PaysController {
    @ApiOperation("Add new data")
    public PaysDTO save(@RequestBody PaysDTO pays);

    @ApiOperation("Find by Id")
    public PaysDTO findById(@PathVariable("id") String id);

    @ApiOperation("Delete based on primary key")
    public void delete(@PathVariable("id") String id);

    @ApiOperation("Find all data")
    public List<PaysDTO> list();

    @ApiOperation("Pagination request")
    public Page<PaysDTO> pageQuery(Pageable pageable);

    @ApiOperation("Update one data")
    public PaysDTO update(@RequestBody PaysDTO dto);
}
