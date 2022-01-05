package com.ibm.academia.apirest.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.ibm.academia.apirest.entities.Lista;

@Repository
public interface ListaRepository extends PagingAndSortingRepository<Lista, Integer> {

}
