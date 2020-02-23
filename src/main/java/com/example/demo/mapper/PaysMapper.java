package com.example.demo.mapper;

import com.example.demo.dto.PaysDTO;
import com.example.demo.model.Pays;
import org.mapstruct.Mapper;

@Mapper(uses=ReferenceMapper.class, componentModel="spring")
public interface PaysMapper extends GenericMapper<Pays, PaysDTO> {
}
