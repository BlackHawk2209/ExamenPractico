package com.ibm.academia.apirest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ibm.academia.apirest.entities.ListaNegra;

public interface ListaNegraRepository extends PagingAndSortingRepository<ListaNegra, Integer>{

	@Query("select l from ListaNegra where l.direccionIp=?1")
	Optional<ListaNegra> buscarPorDireccionIp(String direccionIp);
	
		
}
