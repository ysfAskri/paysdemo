package com.example.demo.mapper;

import com.example.demo.dto.PaysDTO;
import com.example.demo.model.Pays;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface PaysMapper extends GenericMapper<Pays, PaysDTO> {
}