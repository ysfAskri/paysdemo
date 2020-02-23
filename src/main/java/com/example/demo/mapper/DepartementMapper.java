package com.example.demo.mapper;

import com.example.demo.dto.DepartementDTO;
import com.example.demo.model.Departement;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DepartementMapper extends GenericMapper<Departement, DepartementDTO> {
}