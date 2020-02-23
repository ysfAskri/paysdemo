package com.example.demo.dao;

import com.example.demo.model.Departement;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartementRepository extends PagingAndSortingRepository<Departement, Long> {
}
