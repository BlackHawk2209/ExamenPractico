package com.ibm.academia.apirest.services;

import java.util.Optional;

import com.ibm.academia.apirest.entities.Lista;

public interface IListaService {

	public Optional<Lista> listarPaisInfo(String direccionIP);
	
	public String agregarListaNegra(String direccionIP);
	
}
