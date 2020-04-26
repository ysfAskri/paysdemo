package com.example.demo.mapper;

import com.example.demo.dto.DepartementDTO;
import com.example.demo.model.Departement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = ReferenceMapper.class)
public interface DepartementMapper extends GenericMapper<Departement, DepartementDTO> {
    @Override
    @Mapping(target = "id", ignore = true)
    Departement asEntity(DepartementDTO dto);
}
