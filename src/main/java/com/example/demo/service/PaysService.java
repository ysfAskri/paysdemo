package com.example.demo.service;

import com.example.demo.dto.PaysDTO;
import com.example.demo.model.Pays;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface PaysService extends GenericService<Pays, String> {

}
