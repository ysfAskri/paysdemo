package com.example.demo.dao;

import com.example.demo.model.Pays;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaysRepository extends PagingAndSortingRepository<Pays, String> {
}